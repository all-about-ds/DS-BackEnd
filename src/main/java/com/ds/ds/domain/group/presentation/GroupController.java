package com.ds.ds.domain.group.presentation;

import com.ds.ds.domain.group.presentation.data.dto.GroupListDto;
import com.ds.ds.domain.group.presentation.data.request.GroupListRequest;
import com.ds.ds.domain.group.presentation.data.response.GroupListResponse;
import com.ds.ds.domain.group.presentation.data.response.GroupResponse;
import com.ds.ds.domain.group.service.FindGroupListService;
import com.ds.ds.domain.group.util.GroupConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<GroupListResponse> findGroupList(@RequestBody GroupListRequest request) {
        GroupListDto dto = findGroupListService.findGroupList(groupConverter.toDto(request));
        List<GroupResponse> groupResponses = dto.getGroups().stream().map(it ->
                groupConverter.toResponse(it)
        ).collect(Collectors.toList());
        GroupListResponse result = groupConverter.toResponse(dto.getPageable(), groupResponses);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
