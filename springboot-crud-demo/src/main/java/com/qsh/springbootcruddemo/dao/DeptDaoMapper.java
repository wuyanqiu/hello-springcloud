package com.qsh.springbootcruddemo.dao;

import com.qsh.springbootcruddemo.entities.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DeptDaoMapper {
    @Select("SELECT * FROM DEPT WHERE ID=#{id}")
    Department getDeptById(Integer id);

    @Select("SELECT * FROM DEPT")
    List<Department> getAllDept();
}
