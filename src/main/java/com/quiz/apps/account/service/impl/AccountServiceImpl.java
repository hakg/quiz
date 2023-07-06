package com.quiz.apps.account.service.impl;

import com.quiz.apps.account.mapper.AccountMapper;
import com.quiz.apps.account.model.UserDTO;
import com.quiz.apps.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService, UserDetailsService {

    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원가입 - 계정 등록
     * @return int
     */
    @Override
    public int insertAccount(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return accountMapper.insertAccount(userDTO);
    }

    /**
     * 로그인 - 스프링 시큐리티 계정 체크 ("/loginProcess" 호출 여기로 탐)
     * @return int
     */

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserDTO userDTO = accountMapper.selectAccountCheck(userId);

        if (userDTO == null) {
            throw new UsernameNotFoundException("존재하지 않는 회원입니다.");
        }

        return User.builder()
                .username(userDTO.getUserId())
                .password(userDTO.getPassword())
                .roles(userDTO.getUserRole())
                .build();
    }
}
