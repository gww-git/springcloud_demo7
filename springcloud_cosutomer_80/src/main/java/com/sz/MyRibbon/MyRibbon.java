package com.sz.MyRibbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRibbon {

    @Bean
    public IRule myIrule(){
        return new MyRibbonRule();   //自定义策略
    }

}
