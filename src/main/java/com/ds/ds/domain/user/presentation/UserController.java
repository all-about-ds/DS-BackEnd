package com.ds.ds.domain.user.presentation;

import com.ds.ds.domain.user.presentation.data.response.UserResponse;
import com.ds.ds.domain.user.service.FindUserService;
import com.ds.ds.domain.user.util.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final FindUserService findUserService;
    private final UserConverter userConverter;

    @GetMapping
    public ResponseEntity<UserResponse> findUser() {

    }
}
