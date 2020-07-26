package com.li.org.service.impl;

import com.li.org.entity.MyUserDetails;
import com.li.org.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserImpl userImpl;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException{
        if ("".equals(s) || s == null) {
            throw new UsernameNotFoundException("用户不能为空");
        }
        User user=userImpl.queryUserByName(s);

        if(user==null){
            throw new UsernameNotFoundException("用户不存在");
        }

        MyUserDetails myUserDetails=new MyUserDetails();
        myUserDetails.setUsername(s);
        myUserDetails.setPassword(user.getPassword());
        myUserDetails.isAccountNonLocked();
        myUserDetails.setUserId(user.getUserId());

        return myUserDetails;
    }
}
