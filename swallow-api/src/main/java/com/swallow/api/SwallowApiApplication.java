package com.swallow.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * swallow-api的启动类
 * @author wanghan
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SwallowApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwallowApiApplication.class, args);
    }

}

