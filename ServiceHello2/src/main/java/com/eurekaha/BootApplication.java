package com.eurekaha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;


@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class BootApplication {
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
	
	
	
	@RequestMapping(value="/hi",method=RequestMethod.GET)
	public String hi(){
		return "hi2";
	}
	

}
