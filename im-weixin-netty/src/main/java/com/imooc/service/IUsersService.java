package com.imooc.service;

import com.imooc.pojo.UsersBean;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author baomidou
 * @since 2021-11-22
 */
public interface IUsersService extends IService<UsersBean> {

    /**
     * 判断用户名是否存在
     */
    boolean queryUsernameIsExist(String username);

    /**
     * 查询用户是否存在
     */
    UsersBean queryUserForLogin(String username,String password);

    /**
     * 用户注册
     */
    UsersBean saveUser(UsersBean usersBean);

}
