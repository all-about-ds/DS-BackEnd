package com.ds.ds.domain.group.util;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.presentation.data.dto.GroupDto;
import com.ds.ds.domain.group.presentation.data.dto.GroupListDto;
import com.ds.ds.domain.group.presentation.data.dto.GroupListSearchRequirementDto;
import com.ds.ds.domain.group.presentation.data.request.GroupListRequest;
import com.ds.ds.domain.group.presentation.data.response.GroupListResponse;
import com.ds.ds.domain.group.presentation.data.response.GroupResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GroupConverter {
    GroupListSearchRequirementDto toDto(Pageable pageable, Optional<String> keyword);
    GroupDto toDto(Group group, Long memberCount);
    GroupListDto toDto(Pageable pageable, List<GroupDto> dto);

    GroupResponse toResponse(GroupDto dto);
    GroupListResponse toResponse(Pageable pageable, List<GroupResponse> response);
}
