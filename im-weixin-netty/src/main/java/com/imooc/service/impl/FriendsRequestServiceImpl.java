package com.imooc.service.impl;

import com.imooc.pojo.FriendsRequest;
import com.imooc.mapper.FriendsRequestMapper;
import com.imooc.service.IFriendsRequestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户请求表 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2021-11-21
 */
@Service
public class FriendsRequestServiceImpl extends ServiceImpl<FriendsRequestMapper, FriendsRequest> implements IFriendsRequestService {

}
