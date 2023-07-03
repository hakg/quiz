package com.quiz.core.security.config;

import com.quiz.apps.account.service.AccountService;
import com.quiz.core.security.filter.CustomAuthenticationFilter;
import com.quiz.core.security.handler.CustomAuthFailureHandler;
import com.quiz.core.security.handler.CustomAuthSuccessHandler;
import com.quiz.core.security.provider.CustomAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

//    private final AccountService accountService;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//    private final AuthenticationManager authenticationManager;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // 정적 자원에 대해서 Security를 적용하지 않음으로 설정
        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//        return (web) -> web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/bootstrap/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.userDetailsService(accountService).passwordEncoder(bCryptPasswordEncoder);
//        authenticationManager = authenticationManagerBuilder.build();

        //AuthenticationFilter authenticationFilter = new AuthenticationFilter();
        //authenticationFilter.setAuthenticationManager(authenticationManager);

//        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager, accountService);

        http.csrf().disable(); // 서버에 인증정보를 저장하지 않기에 csrf를 사용하지 않는다.
        http.formLogin().disable(); // form 기반의 로그인에 대해 비 활성화하며 커스텀으로 구성한 필터를 사용한다.
//        http.authorizeHttpRequests((authz) -> authz.anyRequest().permitAll()); // 토큰을 활용하는 경우 모든 요청에 대해 '인가'에 대해서 사용.
//        http.addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class); // Spring Security Custom Filter Load - Form '인증'에 대해서 사용
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Session 기반의 인증기반을 사용하지 않고 추후 JWT를 이용하여서 인증 예정

//        http.authorizeRequests()
//                .antMatchers("/login", "/signup", "/index").permitAll()
//                .anyRequest().authenticated() // 다른 요청은 인증이 필요하도록 설정
//                .and()
//                .authenticationManager(authenticationManager)
//                .addFilter(authenticationFilter)
        ;
        return http.build();
    }

    /**
     * 3. authenticate 의 인증 메서드를 제공하는 매니져로'Provider'의 인터페이스를 의미합니다.
     * - 과정: CustomAuthenticationFilter → AuthenticationManager(interface) → CustomAuthenticationProvider(implements)
     *
     * @return AuthenticationManager
     */
    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(customAuthenticationProvider());
    }

    /**
     * 4. '인증' 제공자로 사용자의 이름과 비밀번호가 요구됩니다.
     * - 과정: CustomAuthenticationFilter → AuthenticationManager(interface) → CustomAuthenticationProvider(implements)
     *
     * @return CustomAuthenticationProvider
     */
    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider(bCryptPasswordEncoder());
    }

    /**
     * 5. 비밀번호를 암호화하기 위한 BCrypt 인코딩을 통하여 비밀번호에 대한 암호화를 수행합니다.
     *
     * @return BCryptPasswordEncoder
     */
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 6. 커스텀을 수행한 '인증' 필터로 접근 URL, 데이터 전달방식(form) 등 인증 과정 및 인증 후 처리에 대한 설정을 구성하는 메서드입니다.
     *
     * @return CustomAuthenticationFilter
     */
    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager());
        customAuthenticationFilter.setFilterProcessesUrl("/api/v1/user/login");     // 접근 URL
        customAuthenticationFilter.setAuthenticationSuccessHandler(customLoginSuccessHandler());    // '인증' 성공 시 해당 핸들러로 처리를 전가한다.
        customAuthenticationFilter.setAuthenticationFailureHandler(customLoginFailureHandler());    // '인증' 실패 시 해당 핸들러로 처리를 전가한다.
        customAuthenticationFilter.afterPropertiesSet();
        return customAuthenticationFilter;
    }

    /**
     * 7. Spring Security 기반의 사용자의 정보가 맞을 경우 수행이 되며 결과값을 리턴해주는 Handler
     *
     * @return CustomLoginSuccessHandler
     */
    @Bean
    public CustomAuthSuccessHandler customLoginSuccessHandler() {
        return new CustomAuthSuccessHandler();
    }

    /**
     * 8. Spring Security 기반의 사용자의 정보가 맞지 않을 경우 수행이 되며 결과값을 리턴해주는 Handler
     *
     * @return CustomAuthFailureHandler
     */
    @Bean
    public CustomAuthFailureHandler customLoginFailureHandler() {
        return new CustomAuthFailureHandler();
    }
}
