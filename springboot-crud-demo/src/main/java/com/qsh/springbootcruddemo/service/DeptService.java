package com.qsh.springbootcruddemo.service;

import com.qsh.springbootcruddemo.entities.Department;
import com.qsh.springbootcruddemo.entities.Employee;

import java.util.List;

public interface DeptService {
    Department getDeptById(Integer id);

    List<Department> getAllDept();

}
