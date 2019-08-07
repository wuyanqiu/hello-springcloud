package com.qsh.springbootcruddemo.controller;

import com.qsh.springbootcruddemo.entities.Department;
import com.qsh.springbootcruddemo.entities.Employee;
import com.qsh.springbootcruddemo.service.DeptService;
import com.qsh.springbootcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import com.qsh.springbootcruddemo.entities.Department;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DeptService deptService;




    @PostMapping("/regVerification")
    @ResponseBody
    public String getVerification(@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

        Employee employee = new Employee();
        employee.setLastName(lastName);
        employee.setEmail(email);
        System.out.println("++++++++++++" + employee);
        //成功的话 result的值为ok
        String result = employeeService.getVerification(employee);
        return result;
    }

    @GetMapping("/emps")
    public String getAllEmp(Model model) {
        List<Employee> allEmp = employeeService.getAllEmp();
        List<Department> allDept = deptService.getAllDept();
        for (Employee employee : allEmp) {
            Integer deptId = employee.getDeptId();
            for (Department depatement : allDept) {
                if (deptId == depatement.getId()) {
                    employee.setDepartment(new Department(deptId, depatement.getDepartmentName()));
                }
            }
        }
        model.addAttribute("emps", allEmp);
        return "emp/list";
    }

    /**
     * 去添加员工页面
     *
     * @param model
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        List<Department> allDept = deptService.getAllDept();
        model.addAttribute("depts", allDept);
        return "emp/add";
    }

    /**
     * 添加员工
     *
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        //   / 代表当前项目下的根路径
        employeeService.addEmp(employee);
        return "redirect:/emps";
    }

    /**
     * 去编辑页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        List<Department> allDept = deptService.getAllDept();
        model.addAttribute("depts", allDept);
        Employee oneEmp = employeeService.getOneEmpById(id);
        model.addAttribute("emp", oneEmp);
        return "emp/add";
    }

    /**
     * 修改员工
     *
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmp(Employee employee) {
        employeeService.updateEmp(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeService.deleteEmp(id);
        return "redirect:/emps";
    }

    @GetMapping("/reg")
    public String toRegPage() {
        System.out.println(123);
        return "emp/reg";
    }

}
