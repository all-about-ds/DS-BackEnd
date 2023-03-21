package com.ds.ds.domain.image.util.impl;

import com.ds.ds.domain.image.presentaion.data.dto.ImageDto;
import com.ds.ds.domain.image.presentaion.data.response.ImageResponse;
import com.ds.ds.domain.image.util.ImageConverter;
import org.springframework.stereotype.Component;

@Component
public class ImageConverterImpl implements ImageConverter {
    @Override
    public ImageDto toDto(String image) {
        return new ImageDto(image);
    }

    @Override
    public ImageResponse toResponse(ImageDto dto) {
        return new ImageResponse(dto.getImage());
    }
}
