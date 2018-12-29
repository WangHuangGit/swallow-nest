package com.swallow.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 统一配置中心服务启动类
 * @author wanghan
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class SwallowConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwallowConfigApplication.class, args);
    }

}

