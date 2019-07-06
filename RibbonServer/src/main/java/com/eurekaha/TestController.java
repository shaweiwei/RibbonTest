package com.eurekaha;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

@RestController
public class TestController {


    @Autowired
    @LoadBalanced
    private  RestTemplate restTemplate;
    @Autowired
    SpringClientFactory springClientFactory;

    @RequestMapping("/consumer")
    public String helloConsumer() throws ExecutionException, InterruptedException {
    	ILoadBalancer loadBalancer = springClientFactory.getLoadBalancer("service-hi");
        List<Server> servers = loadBalancer.getReachableServers();
    	System.out.println(",......"+servers.size());
        return restTemplate.getForEntity("http://service-hi/hi",String.class).getBody();
    }
}