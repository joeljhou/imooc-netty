package com.imooc.pojo.vo;

import lombok.Data;

/**
 * 前端显示：后续扩展字段都会放在VO里面
 */
@Data
public class UsersVO {

    private String id;
    private String username;
    private String faceImage;
    private String faceImageBig;
    private String nickname;
    private String qrcode;

}
