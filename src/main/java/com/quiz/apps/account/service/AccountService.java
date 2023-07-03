package com.quiz.apps.account.service;

import com.quiz.apps.account.model.User;
import com.quiz.apps.account.model.UserDTO;

import java.util.Optional;

public interface AccountService {

    int insertAccount(User user);

    Optional<UserDTO> selectAccountCheck(User user);
}
