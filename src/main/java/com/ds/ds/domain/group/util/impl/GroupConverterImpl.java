package com.ds.ds.domain.group.util.impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.presentation.data.dto.GroupDto;
import com.ds.ds.domain.group.presentation.data.dto.GroupListDto;
import com.ds.ds.domain.group.presentation.data.dto.GroupListSearchRequirementDto;
import com.ds.ds.domain.group.presentation.data.request.GroupListRequest;
import com.ds.ds.domain.group.presentation.data.response.GroupListResponse;
import com.ds.ds.domain.group.presentation.data.response.GroupResponse;
import com.ds.ds.domain.group.util.GroupConverter;
import org.springframework.data.domain.PageRequest;
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
    public GroupDto toDto(Group group, Long memberCount) {
        return GroupDto.builder()
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
    public GroupListResponse toResponse(Pageable pageable, List<GroupResponse> response) {
        return GroupListResponse.builder()
                .size(pageable.getPageSize())
                .page(pageable.getPageNumber())
                .groups(response)
                .build();
    }
}
