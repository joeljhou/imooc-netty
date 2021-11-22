package com.imooc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户关联表
 * </p>
 *
 * @author baomidou
 * @since 2021-11-22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("my_friends")
@ApiModel(value = "MyFriendsBean对象", description = "用户关联表")
public class MyFriendsBean extends Model<MyFriendsBean> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户关联表id")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty("我的用户id")
    private String myUserId;

    @ApiModelProperty("我好友用户id")
    private String myFriendUserId;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
