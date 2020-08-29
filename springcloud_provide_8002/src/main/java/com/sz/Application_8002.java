package com.sz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient   //设置为Eureka的客户端，当服务启动时，会注册进eureka
@EnableDiscoveryClient  // 服务发现
public class Application_8002 {
    public static void main(String[] args) {
        SpringApplication.run(Application_8002.class,args);
    }
}
