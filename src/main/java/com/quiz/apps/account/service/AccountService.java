package com.quiz.apps.account.service;

import com.quiz.apps.account.model.UserDTO;

public interface AccountService {

    int insertAccount(UserDTO userDTO);

    int selectAccountDupCheck(String userId);
}
