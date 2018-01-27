package com.hfcsbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//使zuul路由生效，应用成为网关
@EnableZuulProxy
//Eruka的client客户端，使其能注册到Eruka服务器中
@EnableDiscoveryClient
//网关设置为oauth2的单点登录模式
@EnableOAuth2Sso
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
}
