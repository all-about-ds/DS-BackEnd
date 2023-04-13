package com.ds.ds.domain.member.service.Impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.repository.GroupRepository;
import com.ds.ds.domain.group.exception.GroupNotFoundException;
import com.ds.ds.domain.group.exception.NotGroupMemberException;
import com.ds.ds.domain.member.domain.repository.MemberRepository;
import com.ds.ds.domain.member.exception.GroupBossException;
import com.ds.ds.domain.member.service.ExitGroupMemberService;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.util.UserUtil;
import com.ds.ds.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExitGroupMemberServiceImpl implements ExitGroupMemberService {
    private final UserUtil userUtil;
    private final MemberRepository memberRepository;
    private final GroupRepository groupRepository;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void exitGroupMember(Long groupIdx) {
        User user = userUtil.currentUser();
        Group group = groupRepository.findById(groupIdx)
                .orElseThrow(() -> new GroupNotFoundException(ErrorCode.GROUP_NOT_FOUND));

        if(group.getUser().equals(user))
            throw new GroupBossException(ErrorCode.GROUP_BOSS);

        if(!memberRepository.existsByUserIdxAndGroupIdx(user.getIdx(), groupIdx))
            throw new NotGroupMemberException(ErrorCode.NOT_GROUP_MEMBER);

        memberRepository.deleteByUserIdxAndGroupIdx(user.getIdx(), groupIdx);
    }
}
