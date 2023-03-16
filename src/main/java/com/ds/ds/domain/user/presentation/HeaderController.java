package com.ds.ds.domain.user.presentation;

import com.ds.ds.domain.user.presentation.data.dto.HeaderDto;
import com.ds.ds.domain.user.presentation.data.response.HeaderResponse;
import com.ds.ds.domain.user.service.GetHeaderService;
import com.ds.ds.domain.user.util.HeaderConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/header")
public class HeaderController {
    private final GetHeaderService getHeaderService;
    private final HeaderConverter headerConverter;

    @GetMapping
    public ResponseEntity<HeaderResponse> get(){
        HeaderDto headerDto = getHeaderService.getHeader();
        HeaderResponse headerResponse = headerConverter.toResponse(headerDto);
        return new ResponseEntity<>(headerResponse, HttpStatus.OK);
    }
}
