package com.li.org.service;

import org.apache.ibatis.annotations.Param;

/**
 * 用户登陆service
 */
public interface LoginService {
    String login(@Param("userName") String userName,
                @Param("password") String password);
}
