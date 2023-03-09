package com.ds.ds.domain.auth.service.Impl;

import com.ds.ds.domain.auth.domain.repository.AuthenticationRepository;
import com.ds.ds.domain.auth.exception.DuplicateEmailException;
import com.ds.ds.domain.auth.exception.DuplicateNameException;
import com.ds.ds.domain.auth.exception.NotAuthenticatedException;
import com.ds.ds.domain.auth.presentation.data.dto.SignUpDto;
import com.ds.ds.domain.auth.service.SignUpService;
import com.ds.ds.domain.auth.util.AuthConverter;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.domain.repository.UserRepository;
import com.ds.ds.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    private final AuthConverter authConverter;
    private final UserRepository userRepository;
    private final AuthenticationRepository authenticationRepository;
    @Override
    @Transactional
    public void signUp(SignUpDto signUpDto) {
        if(userRepository.existsByName(signUpDto.getName()))
            throw new DuplicateNameException(ErrorCode.DUPLICATE_NAME);
        else if(userRepository.existsByEmail(signUpDto.getEmail()))
            throw new DuplicateEmailException(ErrorCode.DUPLICATE_EMAIL);
        else if(!authenticationRepository.existsById(signUpDto.getEmail())) {
            throw new NotAuthenticatedException(ErrorCode.NOT_AUTHENTICATED);
        }

        User user = authConverter.toEntity(signUpDto);
        userRepository.save(user);
    }
}
