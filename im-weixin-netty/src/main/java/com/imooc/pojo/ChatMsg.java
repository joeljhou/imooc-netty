package com.imooc.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 聊天记录表
 * </p>
 *
 * @author baomidou
 * @since 2021-11-21
 */
@TableName("chat_msg")
@ApiModel(value = "ChatMsg对象", description = "聊天记录表")
public class ChatMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("聊天记录id")
    private String id;

    @ApiModelProperty("发送者用户id")
    private String sendUserId;

    @ApiModelProperty("接收者用户id")
    private String acceptUserId;

    @ApiModelProperty("消息内容")
    private String msg;

    @ApiModelProperty("签收状态")
    private Integer signFlag;

    @ApiModelProperty("消息发送时间")
    private LocalDateTime createTime;

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
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Integer getSignFlag() {
        return signFlag;
    }

    public void setSignFlag(Integer signFlag) {
        this.signFlag = signFlag;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ChatMsg{" +
            "id=" + id +
            ", sendUserId=" + sendUserId +
            ", acceptUserId=" + acceptUserId +
            ", msg=" + msg +
            ", signFlag=" + signFlag +
            ", createTime=" + createTime +
        "}";
    }
}
