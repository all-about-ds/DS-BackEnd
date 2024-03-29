package com.ds.ds.domain.user.util.Impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.presentation.data.dto.HeaderDto;
import com.ds.ds.domain.user.presentation.data.dto.UpdateUserNameDto;
import com.ds.ds.domain.user.presentation.data.dto.UpdateUserProfileImgDto;
import com.ds.ds.domain.user.presentation.data.dto.UserDto;
import com.ds.ds.domain.user.presentation.data.request.UpdateUserNameRequest;
import com.ds.ds.domain.user.presentation.data.request.UpdateUserProfileImgRequest;
import com.ds.ds.domain.user.presentation.data.response.HeaderResponse;
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
        return new UserDto.GroupDto(group.getIdx(), group.getGroupName(), group.getGroupImg());
    }

    @Override
    public UpdateUserNameDto toDto(UpdateUserNameRequest request) {
        return UpdateUserNameDto.builder()
                .name(request.getName())
                .build();
    }

    @Override
    public UpdateUserProfileImgDto toDto(UpdateUserProfileImgRequest request) {
        return UpdateUserProfileImgDto.builder()
                .updateUserProfileImg(request.getUpdateUserProfile())
                .build();
    }

    @Override
    public HeaderDto toDto(User user) {
        return HeaderDto.builder()
                .name(user.getName())
                .img(user.getProfileImg())
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
        return new UserResponse.GroupResponse(dto.getIdx(), dto.getName(), dto.getImg());
    }

    @Override
    public HeaderResponse toResponse(HeaderDto headerDto) {
        return HeaderResponse.builder()
                .name(headerDto.getName())
                .img(headerDto.getImg())
                .build();
    }
}
