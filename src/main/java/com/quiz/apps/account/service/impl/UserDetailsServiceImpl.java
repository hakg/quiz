package com.quiz.apps.account.service.impl;

import java.util.Collections;

import com.quiz.apps.account.model.UserDTO;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

//    private final UserService userService;
//
//    public UserDetailsServiceImpl(UserService us) {
//        this.userService = us;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String userId) {
//        UserDTO userDto = UserDTO
//                .builder()
//                .userId(userId)
//                .build();
//
//        // 사용자 정보가 존재하지 않는 경우
//        if (userId == null || userId.equals("")) {
//            return userService.login(userDto)
//                    .map(u -> new UserDetailsDto(u, Collections.singleton(new SimpleGrantedAuthority(u.getUserId()))))
//                    .orElseThrow(() -> new AuthenticationServiceException(userId));
//        }
//        // 비밀번호가 맞지 않는 경우
//        else {
//            return userService.login(userDto)
//                    .map(u -> new UserDetailsDto(u, Collections.singleton(new SimpleGrantedAuthority(u.getUserId()))))
//                    .orElseThrow(() -> new BadCredentialsException(userId));
//        }
//    }

}