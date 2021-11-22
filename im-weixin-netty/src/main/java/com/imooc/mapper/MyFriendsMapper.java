package com.imooc.mapper;

import com.imooc.pojo.MyFriendsBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户关联表 Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2021-11-22
 */
@Mapper
public interface MyFriendsMapper extends BaseMapper<MyFriendsBean> {

}
