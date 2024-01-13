package com.quiz.web.account.controller;

import com.quiz.apps.account.model.UserDTO;
import com.quiz.apps.account.service.AccountService;
import com.quiz.apps.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/login")
    public String loginForm(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            // 이미 로그인된 사용자인 경우 /index로 리다이렉트
            return "redirect:/index";
        }
        return "login";
    }

    @GetMapping("/signup")
    public String signup(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            // 이미 로그인된 사용자인 경우 /index로 리다이렉트
            return "redirect:/index";
        }
        return "signup";
    }

    @GetMapping("/index")
    public String index(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("userName", user.getUsername());
        return "index";
    }

    @PostMapping("/signup")
    @ResponseBody
    public CommonResponse signupSubmit(@RequestBody UserDTO userDTO) {
        CommonResponse commonResponse = new CommonResponse();

        if (!StringUtils.hasText(userDTO.getUserId()) || !StringUtils.hasText(userDTO.getUserId())
                || !StringUtils.hasText(userDTO.getUserId())) {
            commonResponse.setCode(400); // 나쁜 요청처리
            commonResponse.setMessage("회원가입 실패하셨습니다. 정보를 확인하여 재시도 해주세요");
            return commonResponse;
        }

        if (accountService.selectAccountDupCheck(userDTO.getUserId()) > 0) {
            // 회원가입 실패 처리
            commonResponse.setCode(401); // 유효한 인증 자격 증명이 없음
            commonResponse.setMessage("이미 존재하는 계정입니다.");
            return commonResponse;
        }

        if (accountService.insertAccount(userDTO) <= 0) {
            // 회원가입 실패 처리
            commonResponse.setCode(400); // 나쁜 요청처리
            commonResponse.setMessage("회원가입 실패하셨습니다. 재시도 해주세요");
        } else {
            // 회원가입 성공 시 처리
            commonResponse.setCode(200); // 요청 정상 응답
            commonResponse.setMessage("회원가입 완료되었습니다.");
        }
        return commonResponse;
    }

    @GetMapping("/account")
    public String account(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("UserDTO", accountService.selectAccountCheck(user.getUsername()));
        return "account";
    }

    @PostMapping("/account/update")
    @ResponseBody
    public CommonResponse accountUpdate(@RequestBody UserDTO userDTO) {
        CommonResponse commonResponse = new CommonResponse();
        List<UserDTO> userDTOList = new ArrayList<>();

        if (accountService.updateAccount(userDTO) <= 0) {
            commonResponse.setCode(400); // 나쁜 요청처리
            commonResponse.setMessage("업데이트 처리할 데이터가 없습니다.");
        } else {
            commonResponse.setCode(200); // 요청 정상 응답
            commonResponse.setMessage("회원정보 수정이 완료되었습니다.");
            userDTOList.add(userDTO);
            commonResponse.setItems(userDTOList);
        }
        return commonResponse;
    }

}