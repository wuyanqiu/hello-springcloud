package com.funtl.hello.spring.cloud.service.admin.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

@Repository
@Mapper
public interface AddUserToDBMapper {

    @Insert("INSERT INTO employee (lastname,email,verification)VALUES (#{lastName},#{email},#{verification})")
    public Integer addEmp(HashMap<String,String> userMap);
}
