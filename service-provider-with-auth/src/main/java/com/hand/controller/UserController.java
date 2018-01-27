package com.hand.controller;

import com.hand.dto.User;
import com.hand.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by 亮着的灯 on 2018/1/3.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            UserDetails user = (UserDetails)principal;
            Collection<? extends GrantedAuthority> collection = user.getAuthorities();
            for(GrantedAuthority c:collection){
                //打印当前登录用户的信息
                UserController.logger.info("当前用户是{}，角色是{}",user.getUsername(),user.getPassword());
            }

        }else{
            UserController.logger.info("为找到当前用户");
        }
        User oneUser = this.userRepository.findOne(id);
        return oneUser;
    }
}
