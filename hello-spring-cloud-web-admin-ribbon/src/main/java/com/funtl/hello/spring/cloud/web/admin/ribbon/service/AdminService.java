package com.funtl.hello.spring.cloud.web.admin.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {

    private String url = "http://hello-spring-cloud-service-admin/addUserToDb";
    @Autowired
    private RestTemplate restTemplate;

    public String addUserToDB( MultiValueMap<String, Object> userMap) {
        String addUserResult = restTemplate.postForObject(url, userMap, String.class);
        System.out.println("result1==================" + addUserResult);
        return addUserResult;
    }
}
