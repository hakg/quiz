package com.quiz.apps.service;

import com.quiz.apps.domain.User;
import com.quiz.apps.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountMapper accountMapper;

    // 회원 등록
    public int insertAccount(User user) {
        return accountMapper.insertAccount(user);
    }
}
