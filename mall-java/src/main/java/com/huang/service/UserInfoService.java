package com.huang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.bean.UserInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huang
 * @since 2021-09-14
 */
public interface UserInfoService extends IService<UserInfo> {

    boolean saveData(UserInfo params);

    boolean checkLoginFlag(UserInfo params);

    UserInfo getByName(String params);

//    String getUserAuthorityInfo(Integer userId);

}
