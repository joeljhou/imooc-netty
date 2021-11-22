package com.imooc.mapper;

import com.imooc.pojo.ChatMsgBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 聊天记录表 Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2021-11-22
 */
@Mapper
public interface ChatMsgMapper extends BaseMapper<ChatMsgBean> {

}
