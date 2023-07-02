package com.quiz.apps.service;

import com.quiz.apps.domain.User;
import com.quiz.apps.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final PasswordEncoder passwordEncoder;

    private final AccountMapper accountMapper;

    // 회원 등록
    public int insertAccount(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return accountMapper.insertAccount(user);
    }

    public int selectAccountCheck(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return accountMapper.selectAccountCheck(user);
    }
}
