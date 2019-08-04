package com.funtl.hello.spring.cloud.web.admin.ribbon.Controller;

import com.funtl.hello.spring.cloud.web.admin.ribbon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

   /* @RequestMapping(value = "hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String message){
        return adminService.sayHi(message);
    }*/

    @GetMapping(value = "hello")
    public String hello(){
        return "hello";
    }
}