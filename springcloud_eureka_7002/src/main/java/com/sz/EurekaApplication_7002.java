package com.sz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //设置为Eureka的服务端
public class EurekaApplication_7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication_7002.class,args);
    }
}
