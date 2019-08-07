package com.qsh.springbootcruddemo.controller;

import com.qsh.springbootcruddemo.entities.Employee;
import com.qsh.springbootcruddemo.service.DeptService;
import com.qsh.springbootcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private EmployeeService employeeService;


    @ResponseBody
    @PostMapping(value = "user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, HttpSession session) {
        System.out.println("登录方法进来了。" + username + password);
        Employee oneEmp = employeeService.getOneEmp(username);
        if (oneEmp != null && oneEmp.getPassword().equals(password)) {
            session.setAttribute("loginUserName", username);
            //return "redirect:/main.html";
            return "success";
        } else {
            return "failed";
        }
    }

}
