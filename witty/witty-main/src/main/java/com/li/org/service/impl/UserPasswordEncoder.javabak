package com.li.org.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 自定义的密码加密方法，实现了PasswordEncoder接口
 *
 */
@Component
public class UserPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        //目前直接返回原密码，加密方式以后再加
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {

        /*if(!encode(charSequence).equals(s)){
            throw new UsernameNotFoundException("密码错误");
        }*/
        return encode(charSequence).equals(s);
    }
}
