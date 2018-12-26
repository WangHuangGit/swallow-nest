package com.swallow.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心
 * @author wanghan
 */

@SpringBootApplication
@EnableEurekaServer
public class SwallowEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwallowEurekaApplication.class, args);
	}

}

