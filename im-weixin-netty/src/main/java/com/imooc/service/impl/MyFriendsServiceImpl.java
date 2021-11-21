package com.imooc.service.impl;

import com.imooc.pojo.MyFriends;
import com.imooc.mapper.MyFriendsMapper;
import com.imooc.service.IMyFriendsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户关联表 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2021-11-21
 */
@Service
public class MyFriendsServiceImpl extends ServiceImpl<MyFriendsMapper, MyFriends> implements IMyFriendsService {

}
