package com.imooc.service.impl;

import com.imooc.pojo.MyFriendsBean;
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
 * @since 2021-11-22
 */
@Service
public class MyFriendsServiceImpl extends ServiceImpl<MyFriendsMapper, MyFriendsBean> implements IMyFriendsService {

}
