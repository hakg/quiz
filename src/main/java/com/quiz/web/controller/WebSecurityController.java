package com.quiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebSecurityController {
    
    @GetMapping(value = "/login")
    public String login() {
        return "login"; // 로그인 페이지로 이동
    }
    @GetMapping(value = "/signup")
    public String signup() {
        return "signup"; // 로그인 페이지로 이동
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String loginPost() {
        return "main"; // 인증 성공 시 리디렉션할 경로를 반환
    }
    
    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public String accessDenied() {
        return "access-denied"; // 접근 거부 페이지로 이동
    }

   @GetMapping("/main")
    public String test() {
        return "index"; // 접근 거부 페이지로 이동
    }
}