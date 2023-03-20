package com.ds.ds.domain.image.service.impl;

import com.ds.ds.domain.image.presentaion.data.dto.ImageDto;
import com.ds.ds.domain.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    @Override
    public ImageDto uploadImage(MultipartFile file) {
        return null;
    }
}
