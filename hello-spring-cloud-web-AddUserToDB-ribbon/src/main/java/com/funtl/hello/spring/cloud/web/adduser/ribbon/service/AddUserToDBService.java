package com.funtl.hello.spring.cloud.web.adduser.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class AddUserToDBService {
    @Autowired
    private RestTemplate restTemplate;
    private String url = "http://hello-spring-cloud-service-admin/addUserToDb";

    public String addUserToDB(MultiValueMap<String, Object> userMap) {
        System.out.println("service 进来了");
        String addUserResult = restTemplate.postForObject(url, userMap, String.class);
        System.out.println("result1==================" + addUserResult);
        return addUserResult;
    }
}
