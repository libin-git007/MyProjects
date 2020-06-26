package com.li.org.service;

import com.li.org.entity.MenuBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface MenuService {

    void add(@RequestBody MenuBean menuBeans);

    void update(@RequestBody MenuBean menuBeans);

    void delete(@RequestBody MenuBean menuBeans);

    List<MenuBean> queryAll();

    List<MenuBean> queryByColumn(@Param("functionCode") String functionCode,
                                 @Param("functionName") String functionName,
                                 @Param("functionType") String functionType);
}
