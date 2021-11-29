package com.imooc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imooc.pojo.UsersBean;
import com.imooc.mapper.UsersMapper;
import com.imooc.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2021-11-22
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, UsersBean> implements IUsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public boolean queryUsernameIsExist(String username) {
        QueryWrapper<UsersBean> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        UsersBean usersBean = usersMapper.selectOne(queryWrapper);
        return usersBean != null;
    }

    //支持当前事务，如果不存在则以非事务方式执行
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public UsersBean queryUserForLogin(String username, String password) {
        UsersBean usersBean = usersMapper.selectOne(new LambdaQueryWrapper<UsersBean>()
                .eq(UsersBean::getUsername, username)
                .eq(UsersBean::getPassword, password));
        return usersBean;
    }

    @Override
    public UsersBean saveUser(UsersBean usersBean) {
        //TODO 为每个用户生成一个唯一的二维码
        usersBean.setQrcode("");
        usersMapper.insert(usersBean);
        return usersBean;
    }

}
