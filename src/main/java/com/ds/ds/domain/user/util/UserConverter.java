package com.ds.ds.domain.user.util;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.presentation.data.dto.UserDto;
import com.ds.ds.domain.user.presentation.data.response.UserResponse;

import java.util.List;

public interface UserConverter {
    UserDto toDto(User user, List<UserDto.GroupDto> dto);
    UserDto.GroupDto toDto(Group group);

    UserResponse toResponse(UserDto dto, List<UserResponse.GroupResponse> responses);
    UserResponse.GroupResponse toResponse(UserDto.GroupDto dto);
}