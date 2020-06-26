package com.li.org.controller;

import com.li.org.entity.ResponseData;
import com.li.org.entity.User;
import com.li.org.enums.ResultCode;
import com.li.org.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/userInfo")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    /*根据用户id查询用户信息*/
    @RequestMapping(value = "/queryUserInfo", method = RequestMethod.GET)
    public ResponseData queryUserInfo(@Param("userId") int userId) {
        ResponseData responseData = new ResponseData();
        List<User> userInfo=userService.queryUserInfo(userId);
        responseData.setData(userInfo);
        responseData.setTotal(userInfo.size());

        return responseData;
    }

    /*更新用户信息*/
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public ResponseData updateUserInfo(User user) {
        ResponseData responseData = new ResponseData();
        userService.updateUserInfo(user);
        responseData.setSuccess(true);
        responseData.setCode(ResultCode.SUCCESS.getCode());
        responseData.setMessage(ResultCode.SUCCESS.getMessage());
        return responseData;
    }
}
