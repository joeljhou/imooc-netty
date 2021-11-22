package com.imooc.service.impl;

import com.imooc.pojo.UsersBean;
import com.imooc.mapper.UsersMapper;
import com.imooc.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
