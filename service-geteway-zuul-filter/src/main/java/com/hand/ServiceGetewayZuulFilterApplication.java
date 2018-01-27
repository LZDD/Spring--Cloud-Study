package com.hand;

import com.hand.filter.PreRequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ServiceGetewayZuulFilterApplication {

	@Bean
	public PreRequestLogFilter preRequestLogFilter(){
		return new PreRequestLogFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceGetewayZuulFilterApplication.class, args);
	}
}
