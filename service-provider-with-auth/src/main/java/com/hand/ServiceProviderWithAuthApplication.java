package com.hand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceProviderWithAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProviderWithAuthApplication.class, args);
	}
}
