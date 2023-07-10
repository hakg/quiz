package com.quiz.web.menu.controller;

import com.quiz.apps.common.CommonResponse;
import com.quiz.apps.menu.model.Menu;
import com.quiz.apps.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    public MenuService menuService;

    @PostMapping("/menuList")
    @ResponseBody
    public CommonResponse getUserMenu() {

        CommonResponse commonResponse = new CommonResponse();

        List<Menu> selectMenu = menuService.selectMenuList();

        commonResponse.setItems(selectMenu);

        return commonResponse;
    }


}
