package com.ds.ds.domain.group.util.impl;

import com.ds.ds.domain.chatting.presentation.data.dto.ChatDto;
import com.ds.ds.domain.chatting.presentation.data.request.CreateChatRequest;
import  com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.entity.GroupHits;
import com.ds.ds.domain.group.domain.entity.GroupSecret;
import com.ds.ds.domain.group.presentation.data.dto.*;
import com.ds.ds.domain.group.presentation.data.request.CreateGroupRequest;
import com.ds.ds.domain.group.presentation.data.request.UpdateGroupRequest;
import com.ds.ds.domain.group.presentation.data.response.*;
import com.ds.ds.domain.group.util.GroupConverter;
import com.ds.ds.domain.member.domain.entity.Member;
import com.ds.ds.domain.timer.domain.entity.Timer;
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
                .name(request.getName())
                .description(request.getDescription())
                .maxCount(request.getMaxCount())
                .img(request.getImg())
                .secret(request.getSecret())
                .password(request.getPassword())
                .build();
    }

    @Override
    public DetailGroupDto toDto(Boolean isMember) {
        return DetailGroupDto.builder()
                .isMember(isMember)
                .build();
    }

    @Override
    public GroupDto toDto(Long memberCount, Group group) {
        return GroupDto.builder()
                .idx(group.getIdx())
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
    public PopularityGroupResponse toResponse(PopularityGroupDto dto) {
        return PopularityGroupResponse.builder()
                .idx(dto.getIdx())
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
    public DetailGroupResponse toResponse(DetailGroupDto dto) {
        return DetailGroupResponse.builder()
                .isMember(dto.getIsMember())
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
    public Group toEntity(CreateGroupDto dto, User user, GroupHits groupHits) {
        return Group.builder()
                .groupName(dto.getName())
                .groupDescription(dto.getDescription())
                .groupMaxCount(dto.getMaxCount())
                .groupImg(dto.getImg())
                .secret(dto.getSecret())
                .user(user)
                .groupHits(groupHits)
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
                .idx(groupIdx)
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
    public Timer toEntity(Group group, User user, boolean activity) {
        return Timer.builder()
                .group(group)
                .user(user)
                .activity(activity)
                .timer(0L)
                .build();

    }

    @Override
    public PopularityGroupDto toGroupDto(Long memberCount, Group group) {
        return PopularityGroupDto.builder()
                .idx(group.getIdx())
                .name(group.getGroupName())
                .img(group.getGroupImg())
                .description(group.getGroupDescription())
                .memberCount(memberCount)
                .maxCount(group.getGroupMaxCount())
                .leaderImg(group.getUser().getProfileImg())
                .leaderName(group.getUser().getName())
                .secret(group.isSecret())
                .hits(group.getGroupHits().getHits())
                .build();
    }

    @Override
    public PopularityGroupListDto toGroupListDto(Pageable pageable, List<PopularityGroupDto> popularityGroups) {
        return PopularityGroupListDto.builder()
                .pageable(pageable)
                .groups(popularityGroups)
                .build();
    }

    @Override
    public PopularityGroupListResponse toGroupResponse(Pageable pageable, List<PopularityGroupResponse> popularityGroupResponses) {
        return PopularityGroupListResponse.builder()
                .size(pageable.getPageSize())
                .page(pageable.getPageNumber())
                .groups(popularityGroupResponses)
                .build();
    }

    @Override
    public UpdateGroupDto toDto(UpdateGroupRequest updateGroupRequest) {
        return UpdateGroupDto.builder()
                .description(updateGroupRequest.getDescription())
                .name(updateGroupRequest.getName())
                .img(updateGroupRequest.getImg())
                .maxCount(updateGroupRequest.getMaxCount())
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
    @Override
    public ChatDto toDto(CreateChatRequest chatRequest) {
        return ChatDto.builder()
                .id(chatRequest.getId())
                .chatRoomId(chatRequest.getChatRoomId())
                .members(chatRequest.getMembers())
                .build();
    }
}
