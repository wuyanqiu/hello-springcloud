package com.qsh.springbootcruddemo.controller;

import com.qsh.springbootcruddemo.entities.Employee;
import com.qsh.springbootcruddemo.service.DeptService;
import com.qsh.springbootcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private EmployeeService employeeService;


    @ResponseBody
    @PostMapping(value = "user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, HttpSession session){
        Employee oneEmp = employeeService.getOneEmp(username);
        session.setAttribute("loginUserName",username);
        if(oneEmp!=null && oneEmp.getPassword().equals(password)){
            //return "redirect:/main.html";
            return "success";
        }else {
            return "failed";
        }

    }
}
