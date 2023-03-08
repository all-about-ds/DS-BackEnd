package com.ds.ds.domain.group.util;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.entity.GroupSecret;
import com.ds.ds.domain.group.presentation.data.dto.*;
import com.ds.ds.domain.group.presentation.data.request.CreateGroupRequest;
import com.ds.ds.domain.group.presentation.data.request.UpdateGroupRequest;
import com.ds.ds.domain.group.presentation.data.response.DetailGroupResponse;
import com.ds.ds.domain.group.presentation.data.response.GroupListResponse;
import com.ds.ds.domain.group.presentation.data.response.GroupResponse;
import com.ds.ds.domain.user.domain.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GroupConverter {
    GroupListSearchRequirementDto toDto(Pageable pageable, Optional<String> keyword);
    UpdateGroupDto toDto(UpdateGroupRequest updateGroupRequest);
    CreateGroupDto toDto(CreateGroupRequest request);
    DetailGroupDto toDto(Group group, Long memberCount);
    GroupDto toDto(Group group);
    GroupListDto toDto(Pageable pageable, List<GroupDto> dto);
    GroupResponse toResponse(GroupDto dto);
    DetailGroupResponse toResponse(DetailGroupDto dto);
    GroupListResponse toResponse(Pageable pageable, List<GroupResponse> response);
    Group toEntity(CreateGroupDto dto, User user);
    GroupSecret toEntity(Group entity, String password);
}
