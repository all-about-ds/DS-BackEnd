package com.ds.ds.domain.group.presentation;

import com.ds.ds.domain.group.presentation.data.dto.DetailGroupDto;
import com.ds.ds.domain.group.presentation.data.dto.GroupListDto;
import com.ds.ds.domain.group.presentation.data.dto.UpdateGroupDto;
import com.ds.ds.domain.group.presentation.data.request.UpdateGroupRequest;
import com.ds.ds.domain.group.presentation.data.request.CreateGroupRequest;
import com.ds.ds.domain.group.presentation.data.response.DetailGroupResponse;
import com.ds.ds.domain.group.presentation.data.response.GroupListResponse;
import com.ds.ds.domain.group.presentation.data.response.GroupResponse;
import com.ds.ds.domain.group.service.CreateGroupService;
import com.ds.ds.domain.group.service.FindGroupListService;
import com.ds.ds.domain.group.service.UpdateGroupService;
import com.ds.ds.domain.group.service.ViewGroupDetailService;
import com.ds.ds.domain.group.util.GroupConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {
    private final GroupConverter groupConverter;
    private final FindGroupListService findGroupListService;
    private final ViewGroupDetailService viewGroupDetailService;
    private final CreateGroupService createGroupService;
    private final UpdateGroupService updateGroupService;

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

    @GetMapping("/detail/{group-idx}")
    public ResponseEntity<DetailGroupResponse> viewGroupDetail(@PathVariable("group-idx")Long groupIdx) {
        DetailGroupDto detailGroupDto = viewGroupDetailService.viewGroupDetail(groupIdx);
        DetailGroupResponse groupResponse = groupConverter.toResponse(detailGroupDto);
        return new ResponseEntity<>(groupResponse, HttpStatus.OK);
    }

    @PatchMapping("{group-idx}")
    public ResponseEntity<Void> updateGroup(@PathVariable("group-idx")Long groupIdx, @RequestBody UpdateGroupRequest updateGroupRequest){
        UpdateGroupDto updateGroupDto = groupConverter.toDto(updateGroupRequest);
        updateGroupService.updateGroup(groupIdx, updateGroupDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createGroup(@RequestBody CreateGroupRequest request) {
        createGroupService.createGroup(groupConverter.toDto(request));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
