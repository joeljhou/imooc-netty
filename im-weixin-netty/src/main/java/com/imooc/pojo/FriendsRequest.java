package com.imooc.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户请求表
 * </p>
 *
 * @author baomidou
 * @since 2021-11-21
 */
@TableName("friends_request")
@ApiModel(value = "FriendsRequest对象", description = "用户请求表")
public class FriendsRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户请求id")
    private String id;

    @ApiModelProperty("发送用户id")
    private String sendUserId;

    @ApiModelProperty("接收用户id")
    private String acceptUserId;

    @ApiModelProperty("发送请求时间")
    private LocalDateTime requestDataTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }
    public String getAcceptUserId() {
        return acceptUserId;
    }

    public void setAcceptUserId(String acceptUserId) {
        this.acceptUserId = acceptUserId;
    }
    public LocalDateTime getRequestDataTime() {
        return requestDataTime;
    }

    public void setRequestDataTime(LocalDateTime requestDataTime) {
        this.requestDataTime = requestDataTime;
    }

    @Override
    public String toString() {
        return "FriendsRequest{" +
            "id=" + id +
            ", sendUserId=" + sendUserId +
            ", acceptUserId=" + acceptUserId +
            ", requestDataTime=" + requestDataTime +
        "}";
    }
}
