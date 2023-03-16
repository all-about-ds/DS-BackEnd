package com.ds.ds.domain.user.util.Impl;

import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.presentation.data.dto.HeaderDto;
import com.ds.ds.domain.user.presentation.data.response.HeaderResponse;
import com.ds.ds.domain.user.util.HeaderConverter;
import org.springframework.stereotype.Component;

@Component
public class HeaderConverterImpl implements HeaderConverter {
    @Override
    public HeaderResponse toResponse(HeaderDto headerDto) {
        return HeaderResponse.builder()
                .name(headerDto.getName())
                .img(headerDto.getImg())
                .build();
    }

    @Override
    public HeaderDto toDto(User user) {
        return HeaderDto.builder()
                .name(user.getName())
                .img(user.getProfileImg())
                .build();
    }
}
