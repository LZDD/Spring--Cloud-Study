package com.hand.controller;

import com.hand.dto.User;
import com.hand.repository.UserRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 亮着的灯 on 2018/1/3.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate testTemplate;

    //描述接口方法信息
    @ApiOperation(value = "获取获取用户信息",notes = "根据用户id获取用户信息")
    //使用该注解描述方法参数信息，此处需要注意的是paramType参数，因为id是路径参数，需要配置成path，否则在UI中访问接口方法时会报错
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户ID",required = true,dataType = "Long",paramType = "path")
    })
    @GetMapping("/provider/{id}")
    public User findById(@PathVariable Long id){
        User oneUser = this.userRepository.findOne(id);
        return oneUser;
    }

    @GetMapping("/sidecarDemo")
    public String findByPath(){
        return this.testTemplate.getForObject("http://service-sidecar-node/",String.class);
    }
}
