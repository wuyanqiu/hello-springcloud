package com.funtl.hello.spring.cloud.web.adduser.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class AddUserRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(AddUserRibbonApplication.class,args);
    }
}
