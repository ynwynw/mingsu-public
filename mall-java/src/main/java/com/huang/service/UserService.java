package com.huang.service;

import com.huang.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huang
 * @since 2021-09-14
 */
public interface UserService extends IService<User> {

    User getByName(String username);

    String getUserAuthorityInfo(Integer userId);

}
