package com.ds.ds.domain.member.presentation;

import com.ds.ds.domain.member.service.ExitGroupMemberService;
import com.ds.ds.domain.member.service.ForcedKickGroupMemberService;
import com.ds.ds.domain.member.service.ManDateGroupMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final ForcedKickGroupMemberService forcedKickGroupMemberService;
    private final ManDateGroupMemberService manDateGroupMemberService;
    private final ExitGroupMemberService exitGroupMemberService;

    @DeleteMapping("/{group-idx}/{user-idx}")
    public ResponseEntity<Void> forcedKickGroupMember(@PathVariable("group-idx")Long groupIdx,
                                                      @PathVariable("user-idx")Long userIdx) {
        forcedKickGroupMemberService.forcedKickGroupMember(groupIdx, userIdx);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{group-idx}/{user-idx}")
    public ResponseEntity<Void> mandateGroupMember(@PathVariable("group-idx")Long groupIdx,
                                                   @PathVariable("user-idx")Long userIdx) {
        manDateGroupMemberService.mandateGroupMember(groupIdx, userIdx);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/exit/{group-idx}")
    public ResponseEntity<Void> exitGroupMember(@PathVariable("group-idx") Long groupIdx) {
        exitGroupMemberService.exitGroupMember(groupIdx);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
