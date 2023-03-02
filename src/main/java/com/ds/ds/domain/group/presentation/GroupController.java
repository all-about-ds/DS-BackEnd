package com.ds.ds.domain.group.presentation;

import com.ds.ds.domain.group.presentation.data.dto.GroupListDto;
import com.ds.ds.domain.group.presentation.data.response.GroupListInfoResponse;
import com.ds.ds.domain.group.service.FindGroupListService;
import com.ds.ds.domain.group.util.GroupConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gruop")
public class GroupController {
    private final GroupConverter groupConverter;
    private final FindGroupListService findGroupListService;

    @GetMapping
    public ResponseEntity<List<GroupListInfoResponse>> findGroupList() {
        List<GroupListDto> dto = findGroupListService.findGroupList();
        List<GroupListInfoResponse> response = dto.stream()
                .map(it -> groupConverter.toResponse(it))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
