package com.funtl.hello.spring.cloud.web.admin.feign.service.hystrix;

import com.funtl.hello.spring.cloud.web.admin.feign.service.EmailService;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceHystrix implements EmailService {

    @Override
    public String sendEmail(String email, String regVerification) {
        return "服务挂了，请稍后重试";
    }
}
