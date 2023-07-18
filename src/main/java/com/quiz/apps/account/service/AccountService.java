package com.quiz.apps.account.service;

import com.quiz.apps.account.model.UserDTO;
import org.springframework.security.core.userdetails.User;

public interface AccountService {

    int insertAccount(UserDTO userDTO);

    int selectAccountDupCheck(String userId);

    UserDTO selectAccountCheck(String userId);

    int updateAccount(UserDTO userDTO);
}
