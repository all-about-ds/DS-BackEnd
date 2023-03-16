package com.ds.ds.domain.group.service.impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.repository.GroupRepository;
import com.ds.ds.domain.group.exception.GroupNotFoundException;
import com.ds.ds.domain.group.exception.NotBossException;
import com.ds.ds.domain.group.exception.NotGroupMemberException;
import com.ds.ds.domain.group.service.ForcedKickGroupMemberService;
import com.ds.ds.domain.member.domain.repository.MemberRepository;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.domain.repository.UserRepository;
import com.ds.ds.domain.user.exception.UserNotFoundException;
import com.ds.ds.domain.user.util.UserUtil;
import com.ds.ds.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ForcedKickGroupMemberServiceImpl implements ForcedKickGroupMemberService {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final MemberRepository memberRepository;
    private final UserUtil userUtil;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void forcedKickGroupMember(Long groupIdx, Long userIdx) {
        User currentUser = userUtil.currentUser();
        User kickUser = userRepository.findById(userIdx)
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));

        Group group = groupRepository.findById(groupIdx)
                .orElseThrow(() -> new GroupNotFoundException(ErrorCode.GROUP_NOT_FOUND));

        if(!Objects.equals(group.getUser(), currentUser)){
            throw new NotBossException(ErrorCode.NOT_BOSS);
        } else if (!memberRepository.existsByUserAndGroup(kickUser, group)) {
            throw new NotGroupMemberException(ErrorCode.NOT_GROUP_MEMBER);
        }

        memberRepository.deleteByUserAndGroup(kickUser, group);
    }
}
