package com.imooc.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "人实体类",description = "实体类封装类 People 的全部属性")
public class People {
    @ApiModelProperty(value = "编号",name = "id",required = true,example = "123")
    private int id;
    private String name;
    @ApiModelProperty(hidden = true)
    private String address;
}
