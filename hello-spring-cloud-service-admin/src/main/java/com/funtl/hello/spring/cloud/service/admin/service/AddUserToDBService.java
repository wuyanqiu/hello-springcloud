package com.funtl.hello.spring.cloud.service.admin.service;

import org.springframework.util.MultiValueMap;

import java.util.HashMap;

public interface AddUserToDBService {
    String addUserToDb(MultiValueMap<String,Object> userMap);
}
