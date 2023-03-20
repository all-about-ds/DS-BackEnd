package com.ds.ds.domain.user.util;

import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.presentation.data.dto.HeaderDto;
import com.ds.ds.domain.user.presentation.data.response.HeaderResponse;

public interface HeaderConverter {
    HeaderResponse toResponse(HeaderDto headerDto);
    HeaderDto toDto(User user);
}
