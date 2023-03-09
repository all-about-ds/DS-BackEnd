package com.ds.ds.domain.user.util.Impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.presentation.data.dto.UserDto;
import com.ds.ds.domain.user.presentation.data.response.UserResponse;
import com.ds.ds.domain.user.util.UserConverter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserConverterImpl implements UserConverter {
    @Override
    public UserDto toDto(User user, List<UserDto.GroupDto> dto) {
        return UserDto.builder()
                .idx(user.getIdx())
                .name(user.getName())
                .profileImg(user.getProfileImg())
                .groups(dto)
                .build();
    }

    @Override
    public UserDto.GroupDto toDto(Group group) {
        return UserDto.GroupDto.builder()
                .idx(group.getIdx())
                .name(group.getGroupName())
                .img(group.getGroupImg())
                .build();
    }

    @Override
    public UserResponse toResponse(UserDto dto, List<UserResponse.GroupResponse> responses) {
        return UserResponse.builder()
                .idx(dto.getIdx())
                .name(dto.getName())
                .profileImg(dto.getProfileImg())
                .groups(responses)
                .build();
    }

    @Override
    public UserResponse.GroupResponse toResponse(UserDto.GroupDto dto) {
        return UserResponse.GroupResponse.builder()
                .idx(dto.getIdx())
                .name(dto.getName())
                .img(dto.getImg())
                .build();
    }
}
