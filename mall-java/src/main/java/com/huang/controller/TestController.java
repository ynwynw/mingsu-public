package com.huang.controller;


import com.huang.common.lang.Result;
import com.huang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserService userService;

    //@PreAuthorize("hasRole('admin')")有该角色就可以访问
    //@PreAuthorize("hasAuthority('vip1')")有vip权限就可以访问
    @GetMapping("/test")
    public Result test(){
        return Result.succ(userService.list());
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/pass")
    public Result pass(){

        String pass = bCryptPasswordEncoder.encode("123456");

        boolean matches = bCryptPasswordEncoder.matches("123456", pass);

        System.out.println("加密后的密码"+pass);
        System.out.println("对比是否正确"+ matches);

        return Result.succ(pass);
    }



}
