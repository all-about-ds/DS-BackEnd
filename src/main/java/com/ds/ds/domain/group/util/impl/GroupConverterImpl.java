package com.ds.ds.domain.group.util.impl;

import  com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.entity.GroupSecret;
import com.ds.ds.domain.group.presentation.data.dto.*;
import com.ds.ds.domain.group.presentation.data.request.CreateGroupRequest;
import com.ds.ds.domain.group.presentation.data.request.JoinGroupRequest;
import com.ds.ds.domain.group.presentation.data.request.UpdateGroupRequest;
import com.ds.ds.domain.group.presentation.data.response.*;
import com.ds.ds.domain.group.util.GroupConverter;
import com.ds.ds.domain.member.domain.entity.Member;
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
                .groupName(request.getName())
                .groupDescription(request.getDescription())
                .groupMaxCount(request.getMaxCount())
                .groupImg(request.getImg())
                .secret(request.getSecret())
                .password(request.getPassword())
                .build();
    }

    @Override
    public DetailGroupDto toDto(Group group, Long memberCount) {
        return DetailGroupDto.builder()
                .name(group.getGroupName())
                .img(group.getGroupImg())
                .description(group.getGroupDescription())
                .memberCount(memberCount)
                .maxCount(group.getGroupMaxCount())
                .leaderImg(group.getUser().getProfileImg())
                .leaderName(group.getUser().getName())
                .secret(group.isSecret())
                .build();
    }

    @Override
    public GroupDto toDto(Long memberCount, Group group) {
        return GroupDto.builder()
                .idx(group.getIdx())
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
                .name(dto.getName())
                .img(dto.getImg())
                .description(dto.getDescription())
                .memberCount(dto.getMemberCount())
                .maxCount(dto.getMaxCount())
                .leaderImg(dto.getLeaderImg())
                .leaderName(dto.getLeaderName())
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
                .name(dto.getName())
                .description(dto.getDescription())
                .img(dto.getImg())
                .head(toResponse(dto.getHead()))
                .memberList(memberDto)
                .host(dto.isHost())
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
    public JoinGroupDto toDto(Long groupIdx, Optional<String> password) {
        String StringPassword = password.toString();
        return JoinGroupDto.builder()
                .groupIdx(groupIdx)
                .password(StringPassword)
                .build();
    }

    @Override
    public Member toEntity(Group group, User user) {
        return Member.builder()
                .group(group)
                .user(user)
                .build();
    }

    @Override
    public UpdateGroupDto toDto(UpdateGroupRequest updateGroupRequest) {
        return UpdateGroupDto.builder()
                .description(updateGroupRequest.getGroupDescription())
                .name(updateGroupRequest.getGroupName())
                .img(updateGroupRequest.getGroupImg())
                .maxCount(updateGroupRequest.getGroupMaxCount())
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
    public GroupMainDto toDto(Group group, List<MemberDto> list, boolean host) {
        return GroupMainDto.builder()
                .idx(group.getIdx())
                .name(group.getGroupName())
                .description(group.getGroupDescription())
                .img(group.getGroupImg())
                .head(toDto(group.getUser()))
                .memberList(list)
                .host(host)
                .build();
    }
}
