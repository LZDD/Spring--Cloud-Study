package com.hand.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by fei.tang@hand-china.com on 2018/1/23.
 * @description 内容交易平台
 */
@RestController
public class ZuulDemoController {


    @RequestMapping(value = "/zuul",method = {RequestMethod.POST,RequestMethod.GET})
    public String zuulDemo(){
        return "Here is zuul Demo method!";
    }
}
