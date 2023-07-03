package com.quiz.apps.account.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String email;
    private String userName;
    private String password;
    private String userGubun;
    private Date lastLoginDate;
    private Date passwordUpdateDate;
}
