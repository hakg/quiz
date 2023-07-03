package com.quiz.apps.account.service.impl;

import com.quiz.apps.account.mapper.AccountMapper;
import com.quiz.apps.account.model.User;
import com.quiz.apps.account.model.UserDTO;
import com.quiz.apps.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;

    /**
     * 회원가입 - 계정 등록
     * @param user 
     * @return int
     */
    @Override
    public int insertAccount(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return accountMapper.insertAccount(user);
    }

    /**
     * 로그인 - 계정 체크
     * @param user
     * @return int
     */
    @Override
    public Optional<UserDTO> selectAccountCheck(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return accountMapper.selectAccountCheck(user);
    }
}
