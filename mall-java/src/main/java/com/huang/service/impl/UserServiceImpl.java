package com.huang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huang.entity.User;
import com.huang.mapper.UserMapper;
import com.huang.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huang
 * @since 2021-09-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserService userService;

    @Override
    public User getByName(String username) {
        return getOne(new QueryWrapper<User>().eq("name",username));
    }

    @Override
    public String getUserAuthorityInfo(Integer userId) {

        String authority = "";

        //获取角色
        User user = getOne(new QueryWrapper<User>().eq("user_id", userId));

        String name = user.getName();

        String username = "ROLE_"+name;

        //获取权限：is_business 是否为商家
        String is_business = user.getIsBusiness();

        authority = username.concat(",").concat(is_business);

        return authority;
    }
}
