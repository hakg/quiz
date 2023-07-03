package com.quiz.web.menu.controller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MenuController {

    @PostMapping
    public String getUserMenu() {



        return "";
    }


}
