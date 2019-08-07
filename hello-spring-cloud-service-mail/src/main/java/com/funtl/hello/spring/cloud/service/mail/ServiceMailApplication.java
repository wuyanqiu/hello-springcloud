package com.funtl.hello.spring.cloud.service.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableEurekaClient
public class ServiceMailApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceMailApplication.class, args);
    }
}
