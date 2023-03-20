package com.ds.ds.domain.member.service.Impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.repository.GroupRepository;
import com.ds.ds.domain.member.exception.AlreadyBossException;
import com.ds.ds.domain.group.exception.GroupNotFoundException;
import com.ds.ds.domain.group.exception.NotBossException;
import com.ds.ds.domain.member.service.ManDateGroupMemberService;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.domain.repository.UserRepository;
import com.ds.ds.domain.user.exception.UserNotFoundException;
import com.ds.ds.domain.user.util.UserUtil;
import com.ds.ds.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MandateGroupMemberServiceImpl implements ManDateGroupMemberService {
    private final GroupRepository groupRepository;
    private final UserUtil userUtil;
    private final UserRepository userRepository;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void mandateGroupMember(Long groupIdx, Long userIdx) {
        User currentUser = userUtil.currentUser();
        User mandateUser = userRepository.findById(userIdx)
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
        Group group = groupRepository.findById(groupIdx)
                .orElseThrow(() -> new GroupNotFoundException(ErrorCode.GROUP_NOT_FOUND));

        if(!group.getUser().equals(currentUser)){
            throw new NotBossException(ErrorCode.NOT_BOSS);
        } else if(mandateUser.equals(currentUser)){
            throw new AlreadyBossException(ErrorCode.ALREADY_BOSS);
        }

        group.updateUser(mandateUser);
    }
}
