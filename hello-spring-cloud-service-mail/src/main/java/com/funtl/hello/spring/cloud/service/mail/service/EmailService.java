package com.funtl.hello.spring.cloud.service.mail.service;



public interface EmailService {
    String sendEmail(String email,String regVerification);
}
