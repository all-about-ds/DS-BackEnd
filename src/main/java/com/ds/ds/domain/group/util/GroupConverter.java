package com.ds.ds.domain.group.util;

import com.ds.ds.domain.group.presentation.data.dto.GroupInfoDto;
import com.ds.ds.domain.group.presentation.data.response.GroupInfoResponse;

public interface GroupConverter {
    GroupInfoResponse toResponse(GroupInfoDto dto);
}
