package com.quiz.apps.account.mapper;

import com.quiz.apps.account.model.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AccountMapper {
    int insertAccount(UserDTO userDTO);

    UserDTO selectAccountCheck(String userId);

    int selectAccountDupCheck(String userId);

    int updateAccount(UserDTO userDTO);
}
