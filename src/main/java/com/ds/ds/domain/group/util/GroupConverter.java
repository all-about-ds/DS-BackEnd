package com.ds.ds.domain.group.util;

import com.ds.ds.domain.group.presentation.data.dto.GroupListDto;
import com.ds.ds.domain.group.presentation.data.dto.GroupListSearchRequirement;
import com.ds.ds.domain.group.presentation.data.request.GroupListRequest;
import com.ds.ds.domain.group.presentation.data.response.GroupListInfoResponse;

public interface GroupConverter {
    GroupListSearchRequirement toDto(GroupListRequest request);
    GroupListInfoResponse toResponse(GroupListDto dto);
}
