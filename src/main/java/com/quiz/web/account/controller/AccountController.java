package com.quiz.web.account.controller;

import com.quiz.apps.account.model.UserDTO;
import com.quiz.apps.account.service.AccountService;
import com.quiz.apps.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping(value = "/login")
    public String loginForm(HttpServletRequest request, HttpServletResponse response) {
        RequestCache requestCache = new HttpSessionRequestCache();
        SavedRequest savedRequest = requestCache.getRequest(request, response);

        try {
            //여러가지 이유로 이전페이지 정보가 없는 경우가 있음.
            request.getSession().setAttribute("prevPage", savedRequest.getRedirectUrl());
        } catch(NullPointerException e) {
            request.getSession().setAttribute("prevPage", "/");
        }
        return "login";
    }

    @GetMapping(value = "/signup")
    public String signup() {
        return "signup"; // 회원가입 페이지로 이동
    }

    @GetMapping("/index")
    public String index(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("userId", user.getUsername());
        return "index";
    }

    @PostMapping("/signup")
    @ResponseBody
    public CommonResponse signupSubmit(@RequestBody UserDTO userDTO) {
        CommonResponse commonResponse = new CommonResponse();

        if (!StringUtils.hasText(userDTO.getUserId()) || !StringUtils.hasText(userDTO.getUserId())
                || !StringUtils.hasText(userDTO.getUserId())) {
            resultJSON.setCode(400); // 나쁜 요청처리
            resultJSON.setMessage("회원가입 실패하셨습니다. 정보를 확인하여 재시도 해주세요");
            return resultJSON;
        }

        if (accountService.selectAccountDupCheck(userDTO.getUserId()) > 0) {
            // 회원가입 실패 처리
            resultJSON.setCode(401); // 유효한 인증 자격 증명이 없음
            resultJSON.setMessage("이미 존재하는 계정입니다.");
            return resultJSON;
        }

        if (accountService.insertAccount(userDTO) > 0) {
            // 회원가입 성공 시 처리
            commonResponse.setCode(200); // 요청 정상 응답
            commonResponse.setMessage("회원가입 완료되었습니다.");
            return commonResponse;
        } else {
            // 회원가입 실패 처리
            commonResponse.setCode(400); // 나쁜 요청처리
            commonResponse.setMessage("회원가입 실패하셨습니다. 재시도 해주세요");
            return commonResponse;
        }
    }

}