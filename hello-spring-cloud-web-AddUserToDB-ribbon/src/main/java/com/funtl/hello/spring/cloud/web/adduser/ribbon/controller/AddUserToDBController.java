package com.funtl.hello.spring.cloud.web.adduser.ribbon.controller;

import com.funtl.hello.spring.cloud.web.adduser.ribbon.service.AddUserToDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddUserToDBController {

    @Autowired
    private AddUserToDBService addUserToDBService;

    @PostMapping("addUserToDb")
    public String addUserToDB(@RequestBody MultiValueMap<String, Object> userMap) {
        System.out.println("controller 进来了");
        return addUserToDBService.addUserToDB(userMap);
    }

}
