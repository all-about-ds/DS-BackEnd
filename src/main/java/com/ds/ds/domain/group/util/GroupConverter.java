package com.ds.ds.domain.group.util;

import com.ds.ds.domain.group.presentation.data.dto.GroupListDto;
import com.ds.ds.domain.group.presentation.data.response.GroupListInfoResponse;

public interface GroupConverter {
    GroupListInfoResponse toResponse(GroupListDto dto);
}
