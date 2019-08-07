package com.funtl.hello.spring.cloud.service.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpI implements EmailService {

    private  static String mailTitle = "请接收验证码";
    //private  static String mailFrom = "强树恒";
    private  static String myEmail = "qshsuperman@163.com";

    private String email = "";
    private String regVerification = "";

    @Autowired
    JavaMailSenderImpl javaMailSender;

    Runnable runnableMail = new Runnable() {
        @Override
        public void run() {
            String mailContent = "您好，您的验证码为：" + regVerification;
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(mailTitle);
            message.setText(mailContent);
            message.setTo(email);
            message.setFrom("qshsuperman@163.com");
            javaMailSender.send(message);
        }
    };

    @Override
    public String sendEmail(String email, String regVerification) {
        this.email = email;
        this.regVerification = regVerification;
        /*String mailContent = "您好，您的验证码为：" + regVerification;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(mailTitle);
        message.setText(mailContent);
        message.setTo(email);
        message.setFrom("qshsuperman@163.com");
        javaMailSender.send(message);*/
        Thread mailThread = new Thread(runnableMail);
        mailThread.start();
        return "ok";
    }


}
