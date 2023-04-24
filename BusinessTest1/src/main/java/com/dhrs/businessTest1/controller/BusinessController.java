package com.dhrs.businessTest1.controller;

import com.dhrs.businessTest1.feign.BaseFeignService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Resource
    BaseFeignService service;

    @RequestMapping("/subtract")
    public String subtract(){
        String base = service.add();
        System.out.println("测试openFeign远程调用"+base);
        System.out.println("测试business服务调用");
        return "测试business服务调用";
    }
}


