package com.quiz.core.security.config;

import com.quiz.core.security.handler.CustomAuthFailureHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final CustomAuthFailureHandler customAuthFailureHandler;

    private final UserDetailsService accountServiceImpl;

    /**
     * 스프링시큐리티 정적 자원 접근 해제
     * @return WebSecurityCustomizer
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // 정적 자원에 대해서 Security를 적용하지 않음으로 설정
        return (web) -> web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/bootstrap/**");
    }

    /**
     * 스프링시큐리티 인증/인가 설정
     * @param http
     * @return SecurityFilterChain
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/login", "/signup").permitAll() // 해당 경로는 접근 제한 없음
                .anyRequest().authenticated(); // 어떠한 URI로 접근하던지 인증이 필요

        http.formLogin()
                .loginPage("/login") // 커스텀 로그인 페이지 경로
                .loginProcessingUrl("/loginProcess") // 로그인버튼 경로
                .usernameParameter("userId") // 키로 사용될 값 (index.jsp - name 값)
                .defaultSuccessUrl("/index") // 로그인 성공시 경로
                .failureHandler(customAuthFailureHandler) // 로그인 인증 실패시 처리 필터
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login") // 로그아웃시 경로
                .invalidateHttpSession(true); // 세션 초기화

        http.sessionManagement() // 동시 접속 해결을 위한 세션 허용 관리
                .maximumSessions(1) // 세션 최대 허용 수
                .maxSessionsPreventsLogin(false) // 세션 수 초과 사용자는 로그인 불가
                .expiredUrl("/login");

        http.rememberMe() // 로그인 정보 저장 기능
                .rememberMeParameter("customCheck") // 체크박스 name
                .alwaysRemember(true)
                .tokenValiditySeconds(86400 * 30) // 유지 기간 초단위 (1일 * 30)
                .userDetailsService(accountServiceImpl);

        return http.build();
    }
}