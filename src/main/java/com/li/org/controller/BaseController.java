package com.li.org.controller;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/*
 *BaseController
 */
@RestController
public class BaseController {
    /*默认分页大小*/
    protected static final String DEFAULT_PAGE_SIZE = "10";
    /*默认当前页*/
    protected static final String DEFAULT_PAGE_NUM = "1";

    /*
     *通用校验token
     *待添加
     */
    protected void checkToken(HttpSession httpSession) {

    }


}
