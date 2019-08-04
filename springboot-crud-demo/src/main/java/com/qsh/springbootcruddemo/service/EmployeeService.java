package com.qsh.springbootcruddemo.service;

import com.qsh.springbootcruddemo.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmp();

    Employee getOneEmp(String username);

    boolean addEmp(Employee employee);

    Employee getOneEmpById(Integer id);

    boolean updateEmp(Employee employee);

    boolean deleteEmp(Integer id);
}
