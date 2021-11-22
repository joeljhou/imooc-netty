package com.imooc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 用户请求表
 * </p>
 *
 * @author baomidou
 * @since 2021-11-22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("friends_request")
@ApiModel(value = "FriendsRequestBean对象", description = "用户请求表")
public class FriendsRequestBean extends Model<FriendsRequestBean> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户请求id")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty("发送用户id")
    private String sendUserId;

    @ApiModelProperty("接收用户id")
    private String acceptUserId;

    @ApiModelProperty("发送请求时间")
    private LocalDateTime requestDataTime;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
