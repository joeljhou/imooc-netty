package com.imooc.controller;

import com.imooc.pojo.People;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
@Api(tags = {"mydemo"},description = "描述")
public class DemoController {

    @ResponseBody
    @ApiOperation(value = "获取人的内容",notes = "通过人的编号查询信息")
    @GetMapping("/getpeople")
    public People getPeople(int id){
        People people = new People();
        people.setId(id);
        people.setName("北京");
        people.setAddress("朝阳");
        return people;
    }

}
