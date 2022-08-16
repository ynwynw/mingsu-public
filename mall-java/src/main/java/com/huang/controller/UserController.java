package com.huang.controller;


import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huang.common.lang.Result;
import com.huang.entity.User;
import com.huang.vo.PassDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huang
 * @since 2021-09-06
 */
@Api("用户操作接口")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {


    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @ApiOperation("获取用户权限接口")
    @GetMapping("/auth")
    public Result getAuthority(Principal principal){
        //Principal表示当前登录的用户
        User user = userService.getByName(principal.getName());

        //获取权限
        String authorityInfo = userService.getUserAuthorityInfo(user.getUserId());
        //String转换成数组
        String[] authorityArray = StringUtils.tokenizeToStringArray(authorityInfo, ",");

        return Result.succ(MapUtil.builder().put("authoritys",authorityArray).map());
    }

    @ApiOperation("获取用户信息接口")
    @GetMapping("/list")
    public Result list(){

        List<User> userList = userService.list();
        return Result.succ(userList);
    }

    @ApiOperation("获取用户总数接口")
    @GetMapping("/sum")
    public Result countBySum(){

        int count = userService.count();

        return Result.succ(count);
    }

    @ApiOperation("获取当前登录用户信息接口")
    @GetMapping("/info")
    public Result info(Principal principal){
        User user = userService.getByName(principal.getName());

        return Result.succ(user);
    }


    @ApiOperation("搜索用户接口")
    @GetMapping("/select/{name}")
    public Result select(@PathVariable("name") String name){

        List<User> userList = new ArrayList<>();

        User user = userService.getByName(name);

        userList.add(user);

        return Result.succ(userList);
    }



    @ApiOperation("用户注册接口")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user){

        String pass = bCryptPasswordEncoder.encode(user.getPass());
        user.setPass(pass);

        userService.save(user);

        return Result.succ("注册成功");
    }

    @ApiOperation("用户修改接口")
    @PostMapping("/update")
    public Result update(@Validated @RequestBody User user, Principal principal){

        User loginUser = userService.getByName(principal.getName());

        loginUser.setName(user.getName());
        loginUser.setPhone(user.getPhone());
        loginUser.setSex(user.getSex());
        loginUser.setAge(user.getAge());
        loginUser.setAddress(user.getAddress());
        loginUser.setIsBusiness(user.getIsBusiness());
        loginUser.setEmail(user.getEmail());

        userService.updateById(loginUser);

        return Result.succ("");
    }

    @ApiOperation("后台用户修改接口")
    @PostMapping("/houUpdate")
    public Result houUpdate(@RequestBody User user){

        userService.updateById(user);

        return Result.succ("");
    }

    @ApiOperation("用户修改密码接口")
    @PostMapping("/updatePass")
    public Result updatePass(@Validated @RequestBody PassDto passDto, Principal principal) {

        User user = userService.getByName(principal.getName());

        boolean matches = bCryptPasswordEncoder.matches(passDto.getPass(),user.getPass());
        if (!matches) {
            return Result.fail("旧密码不正确");
        }

        user.setPass(bCryptPasswordEncoder.encode(passDto.getNewPass()));

        userService.updateById(user);

        return Result.succ("");
    }

    @ApiOperation("用户删除接口")
    @PostMapping("/delete")
    public Result deleteById(@RequestBody Integer[] ids){
        userService.removeByIds(Arrays.asList(ids));
        return Result.succ("删除成功");
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("admin"));
    }
}