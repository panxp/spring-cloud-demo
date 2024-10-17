package org.micro.user.controller;

import org.micro.user.entity.User;
import org.micro.user.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getuser(@PathVariable int id) {
        System.out.println("==========admin controller exec");
        return userFeignClient.findbyid(id);


        //负载均衡的写法
        //return restTemplate.getForObject("http://userservice/user/" + id, User.class);

        //不通过eureka的写法
        //User user= restTemplate.getForObject("http://127.0.0.1:9001/user/1",User.class);
        //通过服务发现的方式调用
//        List<ServiceInstance> instances = discoveryClient.getInstances("userService");
//        ServiceInstance serviceInstance = instances.get(0);
//        User user = restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort()
//                + "/user/" + id, User.class);
//        return user;

    }
}