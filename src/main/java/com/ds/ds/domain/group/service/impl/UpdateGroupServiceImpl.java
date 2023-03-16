package com.ds.ds.domain.group.service.impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.entity.GroupSecret;
import com.ds.ds.domain.group.domain.repository.GroupRepository;
import com.ds.ds.domain.group.domain.repository.GroupSecretRepository;
import com.ds.ds.domain.group.exception.GroupNotFoundException;
import com.ds.ds.domain.group.exception.InValidMaxCountException;
import com.ds.ds.domain.group.exception.NotBossException;
import com.ds.ds.domain.group.presentation.data.dto.UpdateGroupDto;
import com.ds.ds.domain.group.service.UpdateGroupService;
import com.ds.ds.domain.group.util.GroupConverter;
import com.ds.ds.domain.member.domain.entity.Member;
import com.ds.ds.domain.member.domain.repository.MemberRepository;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.util.UserUtil;
import com.ds.ds.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateGroupServiceImpl implements UpdateGroupService {
    private final GroupRepository groupRepository;
    private final GroupSecretRepository groupSecretRepository;
    private final UserUtil userUtil;
    private final MemberRepository memberRepository;
    private final GroupConverter groupConverter;
    @Override
    @Transactional
    public void updateGroup(Long groupIdx, UpdateGroupDto updateGroupDto) {
        User user = userUtil.currentUser();
        Group group = groupRepository.findById(groupIdx)
                .orElseThrow(() -> new GroupNotFoundException(ErrorCode.GROUP_NOT_FOUND));
        List<Member> memberList = memberRepository.findMemberByGroup(group);

        if(!group.getUser().getIdx().equals(user.getIdx())){
            throw new NotBossException(ErrorCode.NOT_BOSS);
        } else if (memberList.size() + 1 > updateGroupDto.getMaxCount()) {
            throw new InValidMaxCountException(ErrorCode.INVALID_MAX_COUNT);
        }

        updateGroup(group, updateGroupDto);
    }

    private void updateGroup(Group group, UpdateGroupDto dto){
        if(!group.isSecret() & dto.getSecret()){
            group.updateGroup(dto);
            groupSecretRepository.deleteByGroupIdx(group.getIdx());
        } else if(group.isSecret() & !dto.getSecret()){
            group.updateGroup(dto);
            GroupSecret groupSecret = groupConverter.toEntity(group, dto.getPassword());
            groupSecretRepository.save(groupSecret);
        } else
            group.updateGroup(dto);
    }
}
