package com.quiz.apps.service;

import com.quiz.apps.model.User;

public interface AccountService {

    int insertAccount(User user);

    int selectAccountCheck(User user);
}
