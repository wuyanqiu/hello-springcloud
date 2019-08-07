package com.funtl.hello.spring.cloud.web.admin.feign.service;

import com.funtl.hello.spring.cloud.web.admin.feign.service.hystrix.MailServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "hello-spring-cloud-service-mail", fallback = MailServiceHystrix.class)
public interface MailService {

    @PostMapping("sendEmail")
    public String sendEmail(@RequestParam("email") String email,
                            @RequestParam("regVerification") String regVerification);
}
