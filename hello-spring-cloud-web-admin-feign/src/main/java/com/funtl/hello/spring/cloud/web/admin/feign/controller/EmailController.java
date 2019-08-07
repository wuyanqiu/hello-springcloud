package com.funtl.hello.spring.cloud.web.admin.feign.controller;

import com.funtl.hello.spring.cloud.web.admin.feign.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {
    @Autowired
    EmailService emailService;

    @PostMapping("sendEmail")
    public String sayHi(@RequestParam("email") String email, @RequestParam("regVerification") String regVerification) {
        System.out.println("没报错");
        return emailService.sendEmail(email,regVerification);
    }

}
