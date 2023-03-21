package com.ds.ds.domain.image.util;

import com.ds.ds.domain.image.presentaion.data.dto.ImageDto;
import com.ds.ds.domain.image.presentaion.data.response.ImageResponse;

public interface ImageConverter {
    ImageDto toDto(String image);
    ImageResponse toResponse(ImageDto dto);
}
