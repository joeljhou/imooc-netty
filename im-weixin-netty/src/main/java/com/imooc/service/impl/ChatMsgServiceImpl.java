package com.imooc.service.impl;

import com.imooc.pojo.ChatMsgBean;
import com.imooc.mapper.ChatMsgMapper;
import com.imooc.service.IChatMsgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 聊天记录表 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2021-11-22
 */
@Service
public class ChatMsgServiceImpl extends ServiceImpl<ChatMsgMapper, ChatMsgBean> implements IChatMsgService {

}
