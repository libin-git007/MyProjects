package com.li.org.service.impl;

import com.li.org.entity.User;
import com.li.org.mapper.UserMapper;
import com.li.org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> queryUserInfo(int userId) {
        return userMapper.queryUserInfo(userId);
    }

    @Override
    public User queryUserByName(String userName) {
        return userMapper.queryUserByName(userName);
    }

    @Override
    @Transactional
    public void updateUserInfo(User user) {
        userMapper.updateUserInfo(user);

    }
}
