package com.swallow.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * swallow-user模块启动类
 * @author wanghan
 */

@SpringBootApplication
@EnableDiscoveryClient
public class SwallowUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwallowUserApplication.class, args);
    }

}

