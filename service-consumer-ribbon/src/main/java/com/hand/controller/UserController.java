package com.hand.controller;

import com.hand.dto.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by 亮着的灯 on 2018/1/3.
 */
@EnableDiscoveryClient
@RestController
public class UserController {
    //实现服务之间的通信
    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value="查询用户",notes="查询用户")
    @GetMapping("/user/{id}")
    @ApiImplicitParam(name="id",value="ID",required = true,dataType = "Long",paramType = "path")
    public User getUser(@PathVariable Long id){
        return this.restTemplate.getForObject("http://service-provider-user/"+id,User.class);
    }

}
