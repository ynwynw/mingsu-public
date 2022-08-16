package com.huang;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huang.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.annotation.Resource;


@SpringBootTest
class HuangJavaApplicationTests {

    @Resource
    JavaMailSenderImpl mailSender;

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {

    }
}
