package com.ds.ds.domain.user.util;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.presentation.data.dto.UpdateUserNameDto;
import com.ds.ds.domain.user.presentation.data.dto.UpdateUserProfileImgDto;
import com.ds.ds.domain.user.presentation.data.dto.UserDto;
import com.ds.ds.domain.user.presentation.data.request.UpdateUserNameRequest;
import com.ds.ds.domain.user.presentation.data.request.UpdateUserProfileImgRequest;
import com.ds.ds.domain.user.presentation.data.response.UserResponse;

import java.util.List;

public interface UserConverter {
    UserDto toDto(User user, List<UserDto.GroupDto> dto);
    UserDto.GroupDto toDto(Group group);
    UpdateUserNameDto toDto(UpdateUserNameRequest request);
    UpdateUserProfileImgDto toDto(UpdateUserProfileImgRequest request);

    UserResponse toResponse(UserDto dto, List<UserResponse.GroupResponse> responses);
    UserResponse.GroupResponse toResponse(UserDto.GroupDto dto);
}
