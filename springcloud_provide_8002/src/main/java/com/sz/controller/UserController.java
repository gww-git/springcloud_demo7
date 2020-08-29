package com.sz.controller;

import com.sz.admin.User;
import com.sz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/getAll")
    @ResponseBody
    public List<User> ByUserAll(){
        return iUserService.ByUserAll();
    }

    @RequestMapping(value = "getId/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User ByUserId(@PathVariable(name = "id") int id){
        return iUserService.ByUserId(id);
    }


    @RequestMapping("/da")
    @ResponseBody
    public User  data(){
        try {
            System.out.println(dataSource);
        } catch (Exception e) {
            System.out.println("null");
        }
        User user=new User();
        return user;
    }


    /**
     *  访问eureka有几个服务，当然这里只是测试，
     *
     */
    @RequestMapping(value = "/discovery")
    @ResponseBody
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("microservicecloud-dept");//查询又没有这个名称的微服务
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }  //打印服务名称，地址，端口，链接
        return this.client;
    }



}
