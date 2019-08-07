package com.funtl.hello.spring.cloud.service.admin.controller;

import com.funtl.hello.spring.cloud.service.admin.service.AddUserToDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Parameter;

@RestController
public class AdminController {

    /*   @Value("${server.port}")
       private String port;

       @GetMapping("/hi")
       public String sayHi(String message) {
           return String.format("hi,your message is : %s ,port is %s", message, port);
       }*/
    @Autowired
    AddUserToDBService addUserToDBService;

    @ResponseBody
    @PostMapping("addUserToDb")
    public String addUserToDB(@RequestBody MultiValueMap<String,Object> userMap){
        System.out.println("add contoller coming");
        System.out.println(userMap);
        return addUserToDBService.addUserToDb(userMap);
    }


}
