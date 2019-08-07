package com.qsh.springbootcruddemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCrudDemoApplicationTests {

//    @Autowired
//    JavaMailSenderImpl javaMailSender;

    @Test
    public void testMail(){
        /*int num = (int)((Math.random()*9+1)*100000);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("请接收验证码");
        message.setText(String.valueOf(num));
        message.setTo("510756382@qq.com");
        message.setFrom("qshsuperman@163.com");
        javaMailSender.send(message);*/
    }


}
