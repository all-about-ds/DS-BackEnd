package com.ds.ds.domain.group.util.impl;

import  com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.entity.GroupSecret;
import com.ds.ds.domain.group.presentation.data.dto.*;
import com.ds.ds.domain.group.presentation.data.request.CreateGroupRequest;
import com.ds.ds.domain.group.presentation.data.request.UpdateGroupRequest;
import com.ds.ds.domain.group.presentation.data.response.*;
import com.ds.ds.domain.group.util.GroupConverter;
import com.ds.ds.domain.user.domain.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GroupConverterImpl implements GroupConverter {
    @Override
    public GroupListSearchRequirementDto toDto(Pageable pageable, Optional<String> keyword) {
        return GroupListSearchRequirementDto.builder()
                .pageable(pageable)
                .keyword(keyword)
                .build();
    }

    @Override
    public CreateGroupDto toDto(CreateGroupRequest request) {
        return CreateGroupDto.builder()
                .groupName(request.getGroupName())
                .groupDescription(request.getGroupDescription())
                .groupMaxCount(request.getGroupMaxCount())
                .groupImg(request.getGroupImg())
                .secret(request.getSecret())
                .password(request.getPassword())
                .build();
    }

    @Override
    public DetailGroupDto toDto(Group group, Long memberCount) {
        return DetailGroupDto.builder()
                .groupName(group.getGroupName())
                .groupImg(group.getGroupImg())
                .groupDescription(group.getGroupDescription())
                .groupMemberCount(memberCount)
                .groupMaxCount(group.getGroupMaxCount())
                .groupLeaderImg(group.getUser().getProfileImg())
                .groupLeaderName(group.getUser().getName())
                .secret(group.isSecret())
                .build();
    }

    @Override
    public GroupDto toDto(Group group) {
        return GroupDto.builder()
                .idx(group.getIdx())
                .groupName(group.getGroupName())
                .groupImg(group.getGroupImg())
                .groupDescription(group.getGroupDescription())
                .groupMaxCount(group.getGroupMaxCount())
                .groupLeaderImg(group.getUser().getProfileImg())
                .groupLeaderName(group.getUser().getName())
                .secret(group.isSecret())
                .build();
    }

    @Override
    public GroupListDto toDto(Pageable pageable, List<GroupDto> dto) {
        return GroupListDto.builder()
                .pageable(pageable)
                .groups(dto)
                .build();
    }

    @Override
    public GroupResponse toResponse(GroupDto dto) {
        return GroupResponse.builder()
                .idx(dto.getIdx())
                .groupName(dto.getGroupName())
                .groupImg(dto.getGroupImg())
                .groupDescription(dto.getGroupDescription())
                .groupMaxCount(dto.getGroupMaxCount())
                .groupLeaderImg(dto.getGroupLeaderImg())
                .groupLeaderName(dto.getGroupLeaderName())
                .secret(dto.getSecret())
                .build();
    }

    @Override
    public DetailGroupResponse toResponse(DetailGroupDto dto) {
        return DetailGroupResponse.builder()
                .groupName(dto.getGroupName())
                .groupImg(dto.getGroupImg())
                .groupDescription(dto.getGroupDescription())
                .groupMemberCount(dto.getGroupMemberCount())
                .groupMaxCount(dto.getGroupMaxCount())
                .groupLeaderImg(dto.getGroupLeaderImg())
                .groupLeaderName(dto.getGroupLeaderName())
                .secret(dto.getSecret())
                .build();
    }

    @Override
    public MemberResponse toResponse(MemberDto dto) {
        return MemberResponse.builder()
                .idx(dto.getIdx())
                .name(dto.getName())
                .profileImg(dto.getProfileImg())
                .build();
    }

    @Override
    public GroupMainResponse toResponse(GroupMainDto dto, List<MemberResponse> memberDto) {
        return GroupMainResponse.builder()
                .idx(dto.getIdx())
                .groupName(dto.getGroupName())
                .groupDescription(dto.getGroupDescription())
                .groupImg(dto.getGroupImg())
                .memberList(memberDto)
                .build();
    }

    @Override
    public GroupListResponse toResponse(Pageable pageable, List<GroupResponse> response) {
        return GroupListResponse.builder()
                .size(pageable.getPageSize())
                .page(pageable.getPageNumber())
                .groups(response)
                .build();
    }

    @Override
    public Group toEntity(CreateGroupDto dto, User user) {
        return Group.builder()
                .groupName(dto.getGroupName())
                .groupDescription(dto.getGroupDescription())
                .groupMaxCount(dto.getGroupMaxCount())
                .groupImg(dto.getGroupImg())
                .secret(dto.getSecret())
                .user(user)
                .build();
    }

    @Override
    public GroupSecret toEntity(Group group, String password) {
        return GroupSecret.builder()
                .group(group)
                .password(password)
                .build();
    }

    @Override
    public UpdateGroupDto toDto(UpdateGroupRequest updateGroupRequest) {
        return UpdateGroupDto.builder()
                .groupDescription(updateGroupRequest.getGroupDescription())
                .groupName(updateGroupRequest.getGroupName())
                .groupImg(updateGroupRequest.getGroupImg())
                .groupMaxCount(updateGroupRequest.getGroupMaxCount())
                .secret(updateGroupRequest.getSecret())
                .password(updateGroupRequest.getPassword())
                .build();
    }

    @Override
    public MemberDto toDto(User user) {
        return MemberDto.builder()
                .idx(user.getIdx())
                .name(user.getName())
                .profileImg(user.getProfileImg())
                .build();
    }

    @Override
    public GroupMainDto toDto(Group group, List<MemberDto> list) {
        return GroupMainDto.builder()
                .idx(group.getIdx())
                .groupName(group.getGroupName())
                .groupDescription(group.getGroupDescription())
                .groupImg(group.getGroupImg())
                .memberList(list)
                .build();
    }
}
