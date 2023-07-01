package com.quiz.web.controller;

import com.quiz.apps.domain.User;
import com.quiz.apps.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String email, @RequestParam String password, Model model) {


//        accountService.selectAccountInfo();

        // 로그인 성공 시 처리
        model.addAttribute("email", email);
        return "redirect:/index";
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@RequestParam String userName, @RequestParam String email, @RequestParam String password, Model model) {
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        if (accountService.insertAccount(user) > 0) {
            // 회원가입 성공 처리
            model.addAttribute("email", email);
        } else {
            // 회원가입 실패 처리
            model.addAttribute("result", "로그이실패");
        }

        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // 대시보드 페이지 로직 작성
        // ...

        return "dashboard";
    }

}
