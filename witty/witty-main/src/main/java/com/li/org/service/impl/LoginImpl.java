package com.li.org.service.impl;

import com.li.org.service.LoginService;

public class LoginImpl implements LoginService {

    @Override
    public String login(String userName, String password) {

        if("admin".equals(userName)&&"admin".equals(password)){
            return "success";
        }
        return "false";
    }
}
