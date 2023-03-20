package com.ds.ds.domain.image.service;

import com.ds.ds.domain.image.presentaion.data.dto.ImageDto;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    ImageDto uploadImage(MultipartFile file);
}
