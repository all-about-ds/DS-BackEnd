package com.ds.ds.domain.user.util.Impl;

import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.domain.repository.UserRepository;
import com.ds.ds.domain.user.exception.PasswordNotMatchException;
import com.ds.ds.domain.user.exception.UserNotFoundException;
import com.ds.ds.domain.user.util.UserUtil;
import com.ds.ds.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUtilImpl implements UserUtil {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
    }

    @Override
    public void checkPassword(String userPassword,String requestPassword) {
        if(!passwordEncoder.matches(requestPassword, userPassword)){
            throw new PasswordNotMatchException(ErrorCode.PASSWORD_NOT_MATCH);
        }
    }
}
