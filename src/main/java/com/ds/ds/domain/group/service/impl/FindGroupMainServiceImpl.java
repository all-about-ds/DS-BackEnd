package com.ds.ds.domain.group.service.impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.repository.GroupRepository;
import com.ds.ds.domain.group.exception.GroupNotFoundException;
import com.ds.ds.domain.group.exception.UserNotMemberException;
import com.ds.ds.domain.group.presentation.data.dto.GroupMainDto;
import com.ds.ds.domain.group.presentation.data.dto.MemberDto;
import com.ds.ds.domain.group.service.FindGroupMainService;
import com.ds.ds.domain.group.util.GroupConverter;
import com.ds.ds.domain.member.domain.repository.MemberRepository;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.util.UserUtil;
import com.ds.ds.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindGroupMainServiceImpl implements FindGroupMainService {
    private final GroupRepository groupRepository;
    private final MemberRepository memberRepository;
    private final GroupConverter groupConverter;
    private final UserUtil userUtil;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public GroupMainDto findGroupMain(Long groupIdx) {
        User user = userUtil.currentUser();

        checkUserJoin(user);

        Group group = groupRepository.findById(groupIdx)
                .orElseThrow(()-> new GroupNotFoundException(ErrorCode.GROUP_NOT_FOUND));

        List<MemberDto> memberList = memberRepository.findMemberByGroup(group).stream()
                .map(member -> groupConverter.toDto(member.getUser()))
                .collect(Collectors.toList());

        return groupConverter.toDto(group, memberList);
    }

    private void checkUserJoin(User user) {
        if(!groupRepository.existsByUser(user) && !memberRepository.existsByUser(user)) {
            throw new UserNotMemberException(ErrorCode.USER_NOT_MEMBER);
        }
    }
}
