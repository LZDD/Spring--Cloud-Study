package com.hand.FeignInter;

import com.hand.dto.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 亮着的灯 on 2018/1/9.
 */
@FeignClient(name="service-provider-user",configuration = FeignConfiguration.class)
public interface UserFeignClient {

    /**
     * 使用feign自带的注解@RequestLine
     * @see https://github.com/OpenFeign.feign
     * @param id
     * @return
     */
    @RequestLine("GET /{id}")
    public User findById(@Param("id") Long id);
}
