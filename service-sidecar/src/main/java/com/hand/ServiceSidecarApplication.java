package com.hand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
@EnableSidecar
public class ServiceSidecarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceSidecarApplication.class, args);
	}
}
