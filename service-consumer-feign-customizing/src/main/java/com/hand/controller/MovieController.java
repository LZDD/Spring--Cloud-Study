package com.hand.controller;

import com.hand.dto.User;
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
public class MovieController {
    //实现服务之间的通信
    @Autowired
    private RestTemplate restTemplate;

    //discover
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/user1/{id}")
    public User getUser(@PathVariable Long id){
        return this.restTemplate.getForObject("http://localhost:8000/"+id,User.class);
    }

/*    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo(){
        System.out.println("showInfo method");
        //return this.discoveryClient.getLocalServiceInstance();
        //DiscoveryClient_SERVICE-PROVIDER-USER/localhost:service-provider-user:8000
        return this.discoveryClient.getInstances("localhost:service-provider-user:8000");
    }*/


}
