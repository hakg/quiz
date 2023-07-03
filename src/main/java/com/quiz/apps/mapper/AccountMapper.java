package com.quiz.apps.mapper;

import com.quiz.apps.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    int insertAccount(User user);

    int selectAccountCheck(User user);
}
