package com.qsh.springbootcruddemo.service;

import com.qsh.springbootcruddemo.dao.EmployeeDaoMapper;
import com.qsh.springbootcruddemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpI implements EmployeeService {

    @Autowired
    private EmployeeDaoMapper employeeDaoMapper;
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
        if(integer!=0){
            return true;
        }else {
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
        return integer!=0?true:false;
    }

    @Override
    public boolean deleteEmp(Integer id) {
        Integer integer = employeeDaoMapper.deleteEmp(id);
        return integer!=0?true:false;
    }
}
