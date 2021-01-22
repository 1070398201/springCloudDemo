package com.gcy.order.service;

import com.gcy.order.balancer.LoadBalancer;
import com.gcy.order.memberFegin.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
//    @Autowired
//    private LoadBalancer loadBalancer;

    @Autowired
    MemberServiceFeign memberServiceFeign;


    @RequestMapping("/orderToMember")
    public String orderToMember() {
        // 从注册中心上获取该注册服务列表
//        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("mayikt-member");
//        ServiceInstance serviceInstance = loadBalancer.getSingleAddres(serviceInstanceList);
//        URI rpcMemberUrl = serviceInstance.getUri();
        // 使用本地rest形式实现rpc调用
//        String result = restTemplate.getForObject("http://mayikt-member" + "/getUser", String.class);

       //使用openFeign 访问member 服务
        String result = memberServiceFeign.getUser(1);
        return "订单调用会员获取结果:" + result;
    }

}
