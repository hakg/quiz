package com.quiz.core.security.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 로그인 실패시 처리 필터
 */
@Component
public class CustomAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        // 실패 시 알림 창을 표시하는 로직을 구현
        String errorMessage = "로그인에 실패했습니다. 접속정보를 확인해주세요.";
        request.setAttribute("userId", request.getParameter("userId"));
        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher("/login?error=true").forward(request, response); // 로그인 페이지로 포워딩
    }
}