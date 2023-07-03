package com.quiz.web.account.controller;

import com.quiz.apps.account.model.User;
import com.quiz.apps.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping(value = "/login")
    public String loginForm() {
        return "login"; // 로그인 페이지로 이동
    }
    @GetMapping(value = "/signup")
    public String signup() {
        return "signup"; // 회원가입 페이지로 이동
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String email, @RequestParam String password, Model model) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        // 조회태우는거 하지 않고 스프링시큐리티 적용필요
        // 로그인 성공 시 처리
        model.addAttribute("email", email);
        return "redirect:/index";
    }

    @PostMapping("/signup")
    public String signupSubmit(@RequestParam String userName, @RequestParam String email, @RequestParam String password, Model model) {
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);

        if (accountService.insertAccount(user) > 0) {
            // 회원가입 성공 시 처리
            model.addAttribute("email", email);
            return "redirect:/index"; // 회원가입 성공 시 대시보드 페이지로 이동
        } else {
            // 회원가입 실패 처리
            model.addAttribute("result", "회원가입 실패");
            return "redirect:/signup"; // 회원가입 실패 시 회원가입 페이지로 이동
        }
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }
}