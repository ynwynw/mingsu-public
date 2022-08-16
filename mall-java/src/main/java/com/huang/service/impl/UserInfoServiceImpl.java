package com.huang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.bean.UserInfo;
import com.huang.mapper.UserInfoMapper;
import com.huang.service.UserInfoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huang
 * @since 2021-09-14
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Override
    public boolean saveData(UserInfo params) {
        params.getInsertInfo();
        return this.save(params);
    }

    @Override
    public boolean checkLoginFlag(UserInfo params){
        List<UserInfo> list = new ArrayList<>();
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<UserInfo>();
        wrapper.eq("user_name",params.getUserName());
        wrapper.eq("user_pwd",params.getUserPwd());
        list = this.list(wrapper);
        if(list.size()>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public UserInfo getByName(String params) {
        return getOne(new QueryWrapper<UserInfo>().eq("user_name",params));
    }
//
//    @Override
//    public String getUserAuthorityInfo(Integer userId) {
//
//        String authority = "";
//
//        //获取角色
//        User user = getOne(new QueryWrapper<User>().eq("user_id", userId));
//
//        String name = user.getName();
//
//        String username = "ROLE_"+name;
//
//        //获取权限：is_business 是否为商家
//        String is_business = user.getIsBusiness();
//
//        authority = username.concat(",").concat(is_business);
//
//        return authority;
//    }
}
