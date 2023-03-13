package com.ds.ds.domain.group.service.impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.entity.GroupSecret;
import com.ds.ds.domain.group.domain.repository.GroupRepository;
import com.ds.ds.domain.group.domain.repository.GroupSecretRepository;
import com.ds.ds.domain.group.exception.GroupNotFoundException;
import com.ds.ds.domain.group.exception.GroupPasswordNotMatchException;
import com.ds.ds.domain.group.presentation.data.dto.JoinGroupDto;
import com.ds.ds.domain.group.service.JoinGroupService;
import com.ds.ds.domain.group.util.GroupConverter;
import com.ds.ds.domain.member.domain.entity.Member;
import com.ds.ds.domain.member.domain.repository.MemberRepository;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.util.UserUtil;
import com.ds.ds.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class JoinGroupServiceImpl implements JoinGroupService {
    private final GroupRepository groupRepository;
    private final UserUtil userUtil;
    private final GroupSecretRepository groupSecretRepository;
    private final MemberRepository memberRepository;
    private final GroupConverter groupConverter;
    @Override
    public void joinGroup(JoinGroupDto joinGroupDto, Long groupIdx) {
        User user = userUtil.currentUser();
        Group group = groupRepository.findById(groupIdx)
                .orElseThrow(() -> new GroupNotFoundException(ErrorCode.GROUP_NOT_FOUND));

        if(group.isSecret()){
            GroupSecret groupSecret = groupSecretRepository.findByGroupIdx(groupIdx);
            if(Objects.equals(joinGroupDto.getPassword(), groupSecret.getPassword())){
                throw new GroupPasswordNotMatchException(ErrorCode.GROUP_PASSWORD_NOT_MATCH);
            }
        }

        Member member = groupConverter.toEntity(group, user);
        memberRepository.save(member);
    }
}
