package com.quiz.apps.account.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDTO {

    // 사용자 아이디
    private String userId;

    // 사용자 패스워드
    private String userPassword;

    // 사용자 이름
    private String userName;

    // 사용자 상태
    private String userStatus;

    @Builder
    UserDTO(String userId, String userPassword, String userName, String userStatus) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userStatus = userStatus;
    }

}