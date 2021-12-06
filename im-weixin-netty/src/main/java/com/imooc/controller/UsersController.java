package com.imooc.controller;

import com.imooc.pojo.UsersBean;
import com.imooc.pojo.bo.UsersBO;
import com.imooc.pojo.vo.UsersVO;
import com.imooc.service.IUsersService;
import com.imooc.util.FastDFSClient;
import com.imooc.util.FileUtils;
import com.imooc.util.IMoocJSONResult;
import com.imooc.util.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2021-11-22
 */
@RestController
@RequestMapping("/u")
public class UsersController {

    @Autowired
    private IUsersService iUsersService;

    @Autowired
    private FastDFSClient fastDFSClient;

    @PostMapping("/registOrLogin")
    public IMoocJSONResult registOrLogin(@RequestBody UsersBean usersBean) throws Exception {

        // 0.判断用户名和密码不能为空
        if (StringUtils.isBlank(usersBean.getUsername()) || StringUtils.isBlank(usersBean.getPassword())) {
            return IMoocJSONResult.errorMap("用户名和密码不能为空...");
        }

        // 1.判断用户名是否存在，如果存在就登录，如果不存在就注册
        boolean usernameIsExist = iUsersService.queryUsernameIsExist(usersBean.getUsername());

        UsersBean userResult = null;
        if (usernameIsExist) {
            // 1.1 登录
            userResult = iUsersService.queryUserForLogin(usersBean.getUsername(), MD5Utils.getMD5Str(usersBean.getPassword()));
            if (userResult == null) {
                return IMoocJSONResult.errorMap("用户名或密码不正确");
            }
        } else {
            // 1.2 注册
            usersBean.setNickname(usersBean.getUsername());
            usersBean.setFaceImage("");
            usersBean.setFaceImageBig("");
            usersBean.setPassword(MD5Utils.getMD5Str(usersBean.getPassword()));
            userResult = iUsersService.saveUser(usersBean);
        }
        UsersVO usersVo = new UsersVO();
        BeanUtils.copyProperties(userResult, usersVo);
        return IMoocJSONResult.ok(usersVo);
    }

    @PostMapping("/uploadFaceBase64")
    public IMoocJSONResult uploadFaceBase64(@RequestBody UsersBO usersBO) throws Exception {

        // 获取前端传过来的base64字符串，然后转换为文件对象再上传
        String base64Data = usersBO.getFaceData();
        String userFacePath = "C:\\" + usersBO.getUserId() + "userface64.png";
        FileUtils.base64ToFile(userFacePath, base64Data);

        // 上传文件到fastdfs
        MultipartFile faceFile = FileUtils.fileToMultipart(userFacePath);
        String url = fastDFSClient.uploadBase64(faceFile);
        System.out.println(url);

        // 获取缩略图的url
        String thump = "_80x80";
        String[] arr = url.split("\\.");
        String thumpImgUrl =  arr[0] + thump + arr[1];

        //更新用户头像
        UsersBean usersBean = new UsersBean();
        usersBean.setId(usersBO.getUserId());
        usersBean.setFaceImage(thumpImgUrl);
        usersBean.setFaceImageBig(url);

        UsersBean usersResult = iUsersService.updateUserInfo(usersBean);

        return  IMoocJSONResult.ok(usersResult);
    }

}
