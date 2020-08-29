package com.sz.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 *  配置类，相当于applicationConfig.xml
 */

@Configuration
public class Config{      //为客户端提供的一个更高包装的rest模板

    @Bean
    @Primary     //注意，必须使用该注解，不然报找不到服务
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


//    @Bean
//    public IRule getIrule(){
//        return new RoundRobinRule();  //轮询
//    }
    //注意，不可同时配置多个策略

}
