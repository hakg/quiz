package com.quiz.apps.account.mapper;

import com.quiz.apps.account.model.User;
import com.quiz.apps.account.model.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AccountMapper {
    int insertAccount(User user);

    Optional<UserDTO> selectAccountCheck(User user);
}
