package com.quiz.web.menu.controller;

import com.quiz.apps.common.ResultJSON;
import com.quiz.apps.menu.model.Menu;
import com.quiz.apps.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MenuController {

    @Autowired
    public MenuService menuService;

    @PostMapping("/menuList")
    @ResponseBody
    public ResultJSON getUserMenu() {

        ResultJSON resultJSON = new ResultJSON();

        List<Menu> selectMenu = menuService.selectMenuList();

        resultJSON.setItems(selectMenu);

        return resultJSON;
    }


}
