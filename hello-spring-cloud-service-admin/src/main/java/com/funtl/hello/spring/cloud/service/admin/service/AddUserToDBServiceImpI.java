package com.funtl.hello.spring.cloud.service.admin.service;

import com.funtl.hello.spring.cloud.service.admin.dao.AddUserToDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AddUserToDBServiceImpI implements AddUserToDBService {
    @Autowired
    AddUserToDBMapper addUserToDBMapper;

    @Override
    public String addUserToDb(MultiValueMap<String,Object> userMap) {
        HashMap<String,String> map = new HashMap<>();
        map.put("lastName",userMap.get("lastname").get(0).toString());
        map.put("email",userMap.get("email").get(0).toString());
        map.put("verification",userMap.get("verification").get(0).toString());
        System.out.println(map);
        return addUserToDBMapper.addEmp(map) == 1 ? "success" : "failed";
    }
}
