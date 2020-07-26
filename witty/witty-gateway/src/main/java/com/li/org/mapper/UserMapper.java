package com.li.org.mapper;

import com.li.org.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> queryUserInfo(@Param("userId") int userId);

    User queryUserByName(@Param("userName") String userName);

    void updateUserInfo(@Param("user") User user);
}
