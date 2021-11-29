package com.imooc.controller;


import com.imooc.pojo.UsersBean;
import com.imooc.pojo.vo.UsersVO;
import com.imooc.service.IUsersService;
import com.imooc.util.IMoocJSONResult;
import com.imooc.util.MD5Utils;
import lombok.SneakyThrows;
import org.apache.catalina.security.SecurityUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/registOrLogin")
    public IMoocJSONResult registOrLogin(@RequestBody UsersBean usersBean) throws Exception{

        // 0.判断用户名和密码不能为空
        if (StringUtils.isBlank(usersBean.getUsername()) || StringUtils.isBlank(usersBean.getPassword())){
            return IMoocJSONResult.errorMap("用户名和密码不能为空...");
        }

        // 1.判断用户名是否存在，如果存在就登录，如果不存在就注册
        boolean usernameIsExist = iUsersService.queryUsernameIsExist(usersBean.getUsername());

        UsersBean userResult = null;
        if (usernameIsExist){
            // 1.1 登录
            userResult = iUsersService.queryUserForLogin(usersBean.getUsername(), MD5Utils.getMD5Str(usersBean.getPassword()));
            if (userResult == null){
                return IMoocJSONResult.errorMap("用户名或密码不正确");
            }
        }else{
            // 1.2 注册
            usersBean.setNickname(usersBean.getUsername());
            usersBean.setFaceImage("");
            usersBean.setFaceImageBig("");
            usersBean.setPassword(MD5Utils.getMD5Str(usersBean.getPassword()));
            userResult = iUsersService.saveUser(usersBean);
        }
        UsersVO usersVo = new UsersVO();
        BeanUtils.copyProperties(userResult,usersVo);
        return IMoocJSONResult.ok(usersVo);
    }

}
