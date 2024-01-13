package com.quiz.apps.account.model;

import com.quiz.core.model.DefaultModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends DefaultModel {
    private String userId;
    private String userName;
    private String password;
    private String userRole;
    private String userStatus;
    private Date lastLoginDate;
    private Date passwordUpdateDate;
}
