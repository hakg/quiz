package com.quiz.apps.mapper;

import com.quiz.apps.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public class AccountMapper {
    public int insertAccount(User user);
}
