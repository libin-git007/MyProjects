package com.li.org.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.li.org.entity.MenuBean;
import com.li.org.entity.RequestData;
import com.li.org.entity.ResponseData;
import com.li.org.service.MenuService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/menu")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;
    //@Autowired
    //private RedisUtil redisUtil;

    /*
     *新增或更新数据
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @Transactional(rollbackFor = Exception.class)
    public String addMenu(@RequestBody List<MenuBean> menuBeans) {
        System.out.println(menuBeans.toString());
        menuBeans.forEach(menu -> {
            //System.out.println(menu.toString());
            if (menu.getFunctionId() == 0) {
                menuService.add(menu);
            } else {
                menuService.update(menu);
            }

        });
        return "success";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Transactional(rollbackFor = Exception.class)
    public String delete(@RequestBody List<MenuBean> menuBeans) {
        for (MenuBean menuBean : menuBeans) {
            menuService.delete(menuBean);
        }
        return "success";
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public List<MenuBean> queryAll() {
        return menuService.queryAll();
    }


    /*获取菜单树json*/
    @RequestMapping(value = "/queryMenuTree", method = RequestMethod.GET)
    public String queryMenuTree() {

        //查询所有菜单数据
        List<MenuBean> menu = menuService.queryAll();

        //生成菜单树
        JSONArray jsonData = new JSONArray();
        //一共两层，最外层目录
        for (MenuBean menuBean : menu) {

            if ("M".equals(menuBean.getFunctionType())) {
                //里面菜单
                JSONObject menuM = JSONObject.parseObject(JSON.toJSONString(menuBean));
                JSONArray jsonArray = new JSONArray();
                for (MenuBean bean : menu) {
                    if ("F".equals(bean.getFunctionType()) && (menuBean.getFunctionCode().equals(bean.getParentFunctionCode()))) {
                        jsonArray.add(bean);
                    }
                }
                menuM.put("detail", jsonArray);
                jsonData.add(menuM);
            }
        }
        return jsonData.toJSONString();
    }

    @RequestMapping(value = "/queryByColumn", method = RequestMethod.POST)
    public ResponseData queryByColumn(@RequestBody Map<String, String> para) {
        RequestData requestData = new RequestData(para, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUM);
        List<MenuBean> dto = menuService.queryByColumn(para.get("functionCode"), para.get("functionName"), para.get("functionType"));

        return new ResponseData(dto);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(@Param("key") String key,
                       @Param("value") String value) {
        //redisUtil.set(key, value);
        //return redisUtil.get(key).toString();
        return "";
    }
    @RequestMapping(value="hello",method = RequestMethod.GET)
    public String helloWorld(){
        return "helloWorld";
    }

}
