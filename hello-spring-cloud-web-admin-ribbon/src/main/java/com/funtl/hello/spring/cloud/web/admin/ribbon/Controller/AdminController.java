package com.funtl.hello.spring.cloud.web.admin.ribbon.Controller;

import com.funtl.hello.spring.cloud.web.admin.ribbon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/go")
    @ResponseBody
    public String test(){
        return "ok";
    }

   @PostMapping("addUserToDb")
    public String sayHi(@RequestBody MultiValueMap<String, Object> userMap){
        return adminService.addUserToDB(userMap);
    }

}
