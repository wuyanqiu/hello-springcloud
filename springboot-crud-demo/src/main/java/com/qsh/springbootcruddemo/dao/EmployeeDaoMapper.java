package com.qsh.springbootcruddemo.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qsh.springbootcruddemo.entities.Department;
import com.qsh.springbootcruddemo.entities.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface EmployeeDaoMapper {

    @Select("select * from employee")
    public List<Employee> getAllEmp();

    @Select("select * from employee where lastname=#{name}")
    public Employee getOneEmp(String name);

    @Select("SELECT * FROM EMPLOYEE WHERE ID=#{id}")
    public Employee getOneEmpById(Integer id);

    @Insert("INSERT INTO employee (lastname,email,gender,deptId,birth)VALUES (#{lastName},#{email},#{gender},#{department.id},#{birth})")
    public Integer addEmp(Employee employee);

    @Update("UPDATE EMPLOYEE SET LASTNAME=#{lastName},EMAIL=#{email},GENDER=#{gender},DEPTID=#{department.id},BIRTH=#{birth} WHERE ID=#{id}")
    public Integer updateEmp(Employee employee);

    @Delete("DELETE FROM EMPLOYEE WHERE id=#{id}")
    public Integer deleteEmp(Integer id);

}
