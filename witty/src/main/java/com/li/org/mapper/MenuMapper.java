package com.li.org.mapper;

import com.li.org.entity.MenuBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {

    void add(@Param("menuBeans") MenuBean menuBeans);

    void update(@Param("menuBeans") MenuBean menuBeans);

    void delete(@Param("menuBeans") MenuBean menuBeans);

    List<MenuBean> queryAll();

    List<MenuBean> queryByColumn(@Param("functionCode") String functionCode,
                                 @Param("functionName") String functionName,
                                 @Param("functionType") String functionType);
    List<MenuBean> queryPage();
}