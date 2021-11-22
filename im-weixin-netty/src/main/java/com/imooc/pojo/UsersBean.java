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
 * 用户表
 * </p>
 *
 * @author baomidou
 * @since 2021-11-22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("users")
@ApiModel(value = "UsersBean对象", description = "用户表")
public class UsersBean extends Model<UsersBean> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty("登录名称")
    private String username;

    @ApiModelProperty("登录密码")
    private String password;

    @ApiModelProperty("用户头像")
    private String faceImage;

    private String faceImageBig;

    @ApiModelProperty("用户昵称")
    private String nickname;

    @ApiModelProperty("扫码")
    private String qrcode;

    @ApiModelProperty("客户端id")
    private String cid;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
