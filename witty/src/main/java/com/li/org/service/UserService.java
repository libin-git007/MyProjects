package com.li.org.service;

import com.li.org.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    List<User> queryUserInfo(@Param("userId") int userId);

    User queryUserByName(@Param("userName") String userName);

    void updateUserInfo(User user);
}
