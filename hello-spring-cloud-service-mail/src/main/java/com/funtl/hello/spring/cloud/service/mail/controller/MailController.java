package com.funtl.hello.spring.cloud.service.mail.controller;

import com.funtl.hello.spring.cloud.service.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailController {

    @Autowired
    EmailService emailService;

    @ResponseBody
    @PostMapping("sendEmail")
    public String sendEmail(@RequestParam("email") String email,
                            @RequestParam("regVerification") String regVerification) {
        System.out.println("1234564564564");
        System.out.println(email);
        System.out.println(regVerification);
        String result = emailService.sendEmail(email, regVerification);
        return "ok";
    }

}
