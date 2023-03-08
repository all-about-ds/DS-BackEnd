package com.ds.ds.domain.auth.service.Impl;

import com.ds.ds.domain.auth.domain.entity.AuthCode;
import com.ds.ds.domain.auth.domain.repository.AuthCodeRepository;
import com.ds.ds.domain.auth.exception.DuplicateEmailException;
import com.ds.ds.domain.auth.exception.DuplicateNameException;
import com.ds.ds.domain.auth.exception.NotAuthenticatedException;
import com.ds.ds.domain.auth.exception.NotFoundEmailException;
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
    private final AuthCodeRepository authCodeRepository;
    @Override
    @Transactional
    public void signUp(SignUpDto signUpDto) {
        if(userRepository.existsByName(signUpDto.getName()))
            throw new DuplicateNameException(ErrorCode.DUPLICATE_NAME);
        else if(userRepository.existsByEmail(signUpDto.getEmail()))
            throw new DuplicateEmailException(ErrorCode.DUPLICATE_EMAIL);

        User user = authConverter.toEntity(signUpDto);

        AuthCode authCode = authCodeRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new NotFoundEmailException(ErrorCode.NOT_FOUND_EMAIL));

        if(authCode.isAuthentication()){
            userRepository.save(user);
        } else {
            throw new NotAuthenticatedException(ErrorCode.NOT_AUTHENTICATED);
        }
    }
}
