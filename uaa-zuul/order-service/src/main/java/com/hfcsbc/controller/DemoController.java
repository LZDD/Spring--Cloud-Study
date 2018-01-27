package com.hfcsbc.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangyunfei on 2017/6/12.
 */
@RestController
public class DemoController {
    @GetMapping("/demo")
    //用户需要有query-demo的权限，admin用户有，但是wyf用户没有
    @PreAuthorize("hasAuthority('query-demo')")
    public String getDemo(){
        return "good";
    }
}
