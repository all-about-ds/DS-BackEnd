package com.ds.ds.domain.group.presentation;

import com.ds.ds.domain.group.presentation.data.dto.GroupListDto;
import com.ds.ds.domain.group.presentation.data.request.GroupListRequest;
import com.ds.ds.domain.group.presentation.data.response.GroupListResponse;
import com.ds.ds.domain.group.presentation.data.response.GroupResponse;
import com.ds.ds.domain.group.service.FindGroupListService;
import com.ds.ds.domain.group.util.GroupConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {
    private final GroupConverter groupConverter;
    private final FindGroupListService findGroupListService;

    @GetMapping
    public ResponseEntity<GroupListResponse> findGroupList(@PageableDefault(size = 5, page = 0) Pageable pageable,
                                                           @RequestParam("keyword")Optional<String> keyword) {
        GroupListDto dto = findGroupListService.findGroupList(groupConverter.toDto(pageable, keyword));
        List<GroupResponse> groupResponses = dto.getGroups().stream()
                .map(groupConverter::toResponse)
                .collect(Collectors.toList());
        GroupListResponse result = groupConverter.toResponse(dto.getPageable(), groupResponses);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
