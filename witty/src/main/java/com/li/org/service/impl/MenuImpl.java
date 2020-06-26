package com.li.org.service.impl;

import com.li.org.entity.MenuBean;
import com.li.org.mapper.MenuMapper;
import com.li.org.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public void add(MenuBean menuBeans) {

         menuMapper.add(menuBeans);
    }

    @Override
    public void update(MenuBean menuBeans) {
        menuMapper.update(menuBeans);
    }

    @Override
    public void delete(MenuBean menuBeans) {
        menuMapper.delete(menuBeans);
    }

    @Override
    public List<MenuBean> queryAll() {
        return menuMapper.queryAll();
    }

    @Override
    public List<MenuBean> queryByColumn(String functionCode, String functionName, String functionType) {
        return menuMapper.queryByColumn(functionCode,functionName,functionType);
    }
}
