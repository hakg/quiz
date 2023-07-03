package com.quiz.apps.service.impl;

import com.quiz.apps.mapper.AccountMapper;
import com.quiz.apps.model.User;
import com.quiz.apps.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final SqlSession sqlSession;

    private final PasswordEncoder passwordEncoder;

    private final AccountMapper accountMapper;

    /**
     * 회원가입 - 계정 등록
     * @param user 
     * @return int
     */
    public int insertAccount(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return accountMapper.insertAccount(user);
    }

    /**
     * 로그인 - 계정 체크
     * @param user
     * @return int
     */
    public int selectAccountCheck(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return accountMapper.selectAccountCheck(user);
    }
}
