package com.qsh.springbootcruddemo.service;

import com.qsh.springbootcruddemo.dao.DeptDaoMapper;
import com.qsh.springbootcruddemo.entities.Department;
import com.qsh.springbootcruddemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpI implements  DeptService {

    @Autowired
    private DeptDaoMapper deptDaoMapper;
    @Override
    public Department getDeptById(Integer id) {
        return deptDaoMapper.getDeptById(id);
    }

    @Override
    public List<Department> getAllDept() {
        return deptDaoMapper.getAllDept();
    }
}
