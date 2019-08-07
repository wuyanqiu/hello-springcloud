package com.funtl.hello.spring.cloud.web.admin.feign.controller;

import com.funtl.hello.spring.cloud.web.admin.feign.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegController {
    @Autowired
    MailService emailService;
   /* @Autowired
    AddUserToDBService addUserToDBService;*/

    @PostMapping("sendEmail")
    public String sendEmail(@RequestParam("email") String email, @RequestParam("regVerification") String regVerification) {
        System.out.println("没报错");
        return emailService.sendEmail(email,regVerification);
    }
    /*@PostMapping("addUserToDb")
    public String addUserToDB(@RequestParam("user") MultiValueMap<String,Object> userMap){
        return addUserToDBService.addUserToDB(userMap);
    }*/

}
