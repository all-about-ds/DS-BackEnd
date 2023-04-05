package com.ds.ds.domain.member.service.Impl;

import com.ds.ds.domain.group.exception.NotGroupMemberException;
import com.ds.ds.domain.member.domain.repository.MemberRepository;
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
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void exitGroupMember(Long groupIdx) {
        User user = userUtil.currentUser();

        if(!memberRepository.existsByUserIdxAndGroupIdx(user.getIdx(), groupIdx)){
            throw new NotGroupMemberException(ErrorCode.NOT_GROUP_MEMBER);
        }
        memberRepository.deleteByUserIdxAndGroupIdx(user.getIdx(), groupIdx);
    }
}
