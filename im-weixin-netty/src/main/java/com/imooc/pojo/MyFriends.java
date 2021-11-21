package com.imooc.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户关联表
 * </p>
 *
 * @author baomidou
 * @since 2021-11-21
 */
@TableName("my_friends")
@ApiModel(value = "MyFriends对象", description = "用户关联表")
public class MyFriends implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户关联表id")
    private String id;

    @ApiModelProperty("我的用户id")
    private String myUserId;

    @ApiModelProperty("我好友用户id")
    private String myFriendUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getMyUserId() {
        return myUserId;
    }

    public void setMyUserId(String myUserId) {
        this.myUserId = myUserId;
    }
    public String getMyFriendUserId() {
        return myFriendUserId;
    }

    public void setMyFriendUserId(String myFriendUserId) {
        this.myFriendUserId = myFriendUserId;
    }

    @Override
    public String toString() {
        return "MyFriends{" +
            "id=" + id +
            ", myUserId=" + myUserId +
            ", myFriendUserId=" + myFriendUserId +
        "}";
    }
}
