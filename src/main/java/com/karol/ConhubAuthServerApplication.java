package com.karol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages= {"com.karol.interfaces.feign"})

public class ConhubAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConhubAuthServerApplication.class, args);
	}
}
