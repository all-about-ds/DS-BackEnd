package com.ds.ds.domain.group.presentation;

import com.ds.ds.domain.group.presentation.data.dto.*;
import com.ds.ds.domain.group.presentation.data.request.UpdateGroupRequest;
import com.ds.ds.domain.group.presentation.data.request.CreateGroupRequest;
import com.ds.ds.domain.group.presentation.data.response.*;
import com.ds.ds.domain.group.service.*;
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
    private final DeleteGroupService deleteGroupService;
    private final FindGroupMainService findGroupMainService;
    private final JoinGroupService joinGroupService;
    private final ForcedKickGroupMemberService forcedKickGroupMemberService;
    private final ManDateGroupMemberService manDateGroupMemberService;

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

    @GetMapping("/information/{group-idx}")
    public ResponseEntity<GroupMainResponse> findGroupMain(@PathVariable("group-idx") Long groupIdx) {
        GroupMainDto dto = findGroupMainService.findGroupMain(groupIdx);

        List<MemberResponse> responses = dto.getMemberList().stream()
                .map(member -> groupConverter.toResponse(member))
                .collect(Collectors.toList());

        GroupMainResponse response = groupConverter.toResponse(dto, responses);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/{group-idx}")
    public ResponseEntity<Void> updateGroup(@PathVariable("group-idx")Long groupIdx, @RequestBody UpdateGroupRequest updateGroupRequest) {
        UpdateGroupDto updateGroupDto = groupConverter.toDto(updateGroupRequest);
        updateGroupService.updateGroup(groupIdx, updateGroupDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Void> createGroup(@RequestBody CreateGroupRequest request) {
        createGroupService.createGroup(groupConverter.toDto(request));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{group-idx}")
    public ResponseEntity<Void> deleteGroup(@PathVariable("group-idx")Long groupIdx) {
        deleteGroupService.deleteGroup(groupIdx);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/join/{group-idx}")
    public ResponseEntity<Void> joinGroup(@PathVariable("group-idx")Long groupIdx,
                                          @RequestParam("password")Optional<String> password) {
        JoinGroupDto joinGroupDto = groupConverter.toDto(groupIdx, password);
        joinGroupService.joinGroup(joinGroupDto, groupIdx);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/member/{group-idx}/{user-idx}")
    public ResponseEntity<Void> forcedKickGroupMember(@PathVariable("group-idx")Long groupIdx,
                                                      @PathVariable("user-idx")Long userIdx) {
        forcedKickGroupMemberService.forcedKickGroupMember(groupIdx, userIdx);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/mandate/{group-idx}/{user-idx}")
    public ResponseEntity<Void> mandateGroupMember(@PathVariable("group-idx")Long groupIdx,
                                        @PathVariable("user-idx")Long userIdx) {
        manDateGroupMemberService.mandateGroupMember(groupIdx, userIdx);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
