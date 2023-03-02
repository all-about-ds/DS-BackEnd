package com.ds.ds.domain.group.util.impl;

import com.ds.ds.domain.group.presentation.data.dto.GroupListDto;
import com.ds.ds.domain.group.presentation.data.dto.GroupListSearchRequirement;
import com.ds.ds.domain.group.presentation.data.request.GroupListRequest;
import com.ds.ds.domain.group.presentation.data.response.GroupListInfoResponse;
import com.ds.ds.domain.group.util.GroupConverter;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class GroupConverterImpl implements GroupConverter {
    @Override
    public GroupListSearchRequirement toDto(GroupListRequest request) {
        return GroupListSearchRequirement.builder()
                .pageable(PageRequest.of(request.getPage(), request.getSize()))
                .keyword(request.getKeyword())
                .build();
    }

    @Override
    public GroupListInfoResponse toResponse(GroupListDto dto) {
        return GroupListInfoResponse.builder()
                .groupName(dto.getGroupName())
                .groupImg(dto.getGroupImg())
                .groupDescription(dto.getGroupDescription())
                .groupmemberCount(dto.getGroupmemberCount())
                .groupMaxCount(dto.getGroupMaxCount())
                .groupLeaderImg(dto.getGroupLeaderImg())
                .groupLeaderName(dto.getGroupLeaderName())
                .secret(dto.getSecret())
                .build();
    }
}
