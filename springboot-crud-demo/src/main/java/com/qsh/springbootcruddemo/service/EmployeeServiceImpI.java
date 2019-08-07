package com.qsh.springbootcruddemo.service;

import com.qsh.springbootcruddemo.dao.EmployeeDaoMapper;
import com.qsh.springbootcruddemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeServiceImpI implements EmployeeService {

    @Autowired
    private EmployeeDaoMapper employeeDaoMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Employee> getAllEmp() {
        return employeeDaoMapper.getAllEmp();
    }

    @Override
    public Employee getOneEmp(String username) {
        return employeeDaoMapper.getOneEmp(username);
    }

    @Override
    public boolean addEmp(Employee employee) {
        Integer integer = employeeDaoMapper.addEmp(employee);
        if (integer != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Employee getOneEmpById(Integer id) {
        return employeeDaoMapper.getOneEmpById(id);
    }

    @Override
    public boolean updateEmp(Employee employee) {
        Integer integer = employeeDaoMapper.updateEmp(employee);
        return integer != 0 ? true : false;
    }

    @Override
    public boolean deleteEmp(Integer id) {
        Integer integer = employeeDaoMapper.deleteEmp(id);
        return integer != 0 ? true : false;
    }

    @Async
    @Override
    public String getVerification(Employee employee) {
        String getVerResult = getVerificate(employee);

        return getVerResult;
    }

    /**
     * 调用发送邮件的服务，获取验证码
     * @param employee
     * @return
     */
    private String getVerificate(Employee employee){
        String url = "http://localhost:8765/sendEmail";
        String regVerification =String.valueOf((int)((Math.random()*9+1)*100000));
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("regVerification",regVerification);
        paramMap.add("email",employee.getEmail());
        String restResult = restTemplate.postForObject(url, paramMap, String.class);
        System.out.println("result1==================" + restResult);
        return restResult;
    }
}
