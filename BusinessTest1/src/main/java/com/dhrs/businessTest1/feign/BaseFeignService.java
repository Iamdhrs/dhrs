package com.dhrs.businessTest1.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "base-service",path = "/base")
public interface BaseFeignService {
    @RequestMapping("/add")
    String add();
}
