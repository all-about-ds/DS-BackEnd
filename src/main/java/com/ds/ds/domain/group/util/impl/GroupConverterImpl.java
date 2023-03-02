package com.ds.ds.domain.group.util.impl;

import com.ds.ds.domain.group.presentation.data.dto.GroupInfoDto;
import com.ds.ds.domain.group.presentation.data.response.GroupInfoResponse;
import com.ds.ds.domain.group.util.GroupConverter;
import org.springframework.stereotype.Component;

@Component
public class GroupConverterImpl implements GroupConverter {
    @Override
    public GroupInfoResponse toResponse(GroupInfoDto dto) {
        return GroupInfoResponse.builder()
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
