package com.imooc.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 聊天记录表
 * </p>
 *
 * @author baomidou
 * @since 2021-11-22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("chat_msg")
@ApiModel(value = "ChatMsgBean对象", description = "聊天记录表")
public class ChatMsgBean extends Model<ChatMsgBean> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("聊天记录id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
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
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
