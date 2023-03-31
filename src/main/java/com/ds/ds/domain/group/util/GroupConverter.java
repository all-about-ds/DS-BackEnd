package com.ds.ds.domain.group.util;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.entity.GroupHits;
import com.ds.ds.domain.group.domain.entity.GroupSecret;
import com.ds.ds.domain.group.presentation.data.dto.*;
import com.ds.ds.domain.group.presentation.data.request.CreateGroupRequest;
import com.ds.ds.domain.group.presentation.data.request.UpdateGroupRequest;
import com.ds.ds.domain.group.presentation.data.response.*;
import com.ds.ds.domain.member.domain.entity.Member;
import com.ds.ds.domain.timer.domain.entity.Timer;
import com.ds.ds.domain.user.domain.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GroupConverter {
    GroupListSearchRequirementDto toDto(Pageable pageable, Optional<String> keyword);
    UpdateGroupDto toDto(UpdateGroupRequest updateGroupRequest);
    MemberDto toDto(User user);
    GroupMainDto toDto(Group group, List<MemberDto> list, boolean isHead);
    CreateGroupDto toDto(CreateGroupRequest request);
    DetailGroupDto toDto(Group group, Long memberCount, Boolean isMember);
    GroupDto toDto(Long memberCount, Group group);
    GroupListDto toDto(Pageable pageable, List<GroupDto> dto);
    GroupResponse toResponse(GroupDto dto);
    PopularityGroupResponse toResponse(PopularityGroupDto dto);
    DetailGroupResponse toResponse(DetailGroupDto dto);
    MemberResponse toResponse(MemberDto dto);
    GroupMainResponse toResponse(GroupMainDto dto, List<MemberResponse> memberResponses);
    GroupListResponse toResponse(Pageable pageable, List<GroupResponse> response);
    Group toEntity(CreateGroupDto dto, User user, GroupHits groupHits);
    GroupSecret toEntity(Group entity, String password);
    JoinGroupDto toDto(Long groupIdx, Optional<String> password);
    Member toEntity(Group group, User user);
    Timer toEntity(Group group, User user, boolean activity);
    PopularityGroupDto toGroupDto(Long memberCount, Group group);
    PopularityGroupListDto toGroupListDto(Pageable pageable, List<PopularityGroupDto> popularityGroups);
    PopularityGroupListResponse toGroupResponse(Pageable pageable, List<PopularityGroupResponse> popularityGroupResponses);
}
