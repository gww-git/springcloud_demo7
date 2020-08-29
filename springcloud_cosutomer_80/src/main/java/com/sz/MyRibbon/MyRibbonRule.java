package com.sz.MyRibbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.client.config.IClientConfig;
import java.util.List;
import java.util.Random;
import java.util.List;
import java.util.Random;

public class MyRibbonRule extends AbstractLoadBalancerRule {

    int total=0;
    int index=0;

    public MyRibbonRule() {
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }


                server = (Server)upList.get(index);

                if (total<5){
                    upList.get(index);
                    total++;
                }else {
                    total=0;
                    index++;
                    if (index>=upList.size()){
                        index=0;
                    }
                    upList.get(index);
                }


                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}


