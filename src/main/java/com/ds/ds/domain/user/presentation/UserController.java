package com.ds.ds.domain.user.presentation;

import com.ds.ds.domain.user.presentation.data.dto.UserDto;
import com.ds.ds.domain.user.presentation.data.request.UpdateUserNameRequest;
import com.ds.ds.domain.user.presentation.data.request.UpdateUserProfileImgRequest;
import com.ds.ds.domain.user.presentation.data.response.UserResponse;
import com.ds.ds.domain.user.service.FindUserService;
import com.ds.ds.domain.user.service.UpdateUserNameService;
import com.ds.ds.domain.user.service.UpdateUserProfileService;
import com.ds.ds.domain.user.service.WithdrawUserService;
import com.ds.ds.domain.user.util.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final FindUserService findUserService;
    private final UserConverter userConverter;
    private final UpdateUserProfileService updateUserProfileService;
    private final WithdrawUserService withdrawUserService;
    private final UpdateUserNameService updateUserNameService

    @GetMapping
    public ResponseEntity<UserResponse> findUser() {
        UserDto dto = findUserService.findUser();

        List<UserResponse.GroupResponse> groupResponse = dto.getGroups().stream()
                .map(group -> userConverter.toResponse(group))
                .collect(Collectors.toList());
        UserResponse result = userConverter.toResponse(dto, groupResponse);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PatchMapping("/image")
    public ResponseEntity<Void> updateUserProfile(@RequestBody UpdateUserProfileImgRequest request) {
        updateUserProfileService.updateUserProfileImg(userConverter.toDto(request));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/name")
    public ResponseEntity<Void> updateName(@RequestBody UpdateUserNameRequest request) {
        updateUserNameService.updateUserName(userConverter.toDto(request));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> withdrawUser() {
        withdrawUserService.withdrawUser();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
