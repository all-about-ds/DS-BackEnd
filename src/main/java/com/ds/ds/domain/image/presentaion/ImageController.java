package com.ds.ds.domain.image.presentaion;

import com.ds.ds.domain.image.presentaion.data.dto.ImageDto;
import com.ds.ds.domain.image.presentaion.data.response.ImageResponse;
import com.ds.ds.domain.image.service.ImageService;
import com.ds.ds.domain.image.util.ImageConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;
    private final ImageConverter imageConverter;

    @PostMapping
    public ResponseEntity<ImageResponse> uploadFile(@Valid @RequestPart(value = "files", required = false) MultipartFile multipartFile){
        ImageDto imageDto = imageService.uploadImage(multipartFile);
        return new ResponseEntity<>(imageConverter.toResponse(imageDto), HttpStatus.OK);
    }
}
