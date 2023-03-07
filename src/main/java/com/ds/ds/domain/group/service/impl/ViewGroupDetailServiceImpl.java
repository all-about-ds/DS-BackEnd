package com.ds.ds.domain.group.service.impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.repository.GroupRepository;
import com.ds.ds.domain.group.exception.GroupNotFoundException;
import com.ds.ds.domain.group.presentation.data.dto.DetailGroupDto;
import com.ds.ds.domain.group.presentation.data.dto.GroupDto;
import com.ds.ds.domain.group.service.ViewGroupDetailService;
import com.ds.ds.domain.group.util.GroupConverter;
import com.ds.ds.domain.member.domain.repository.MemberRepository;
import com.ds.ds.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ViewGroupDetailServiceImpl implements ViewGroupDetailService {
    private final GroupRepository groupRepository;
    private final GroupConverter groupConverter;
    private final MemberRepository memberRepository;

    @Override
    public DetailGroupDto viewGroupDetail(Long groupIdx) {
        Group group = groupRepository.findById(groupIdx)
                .orElseThrow(() -> new GroupNotFoundException(ErrorCode.GROUP_NOT_FOUND));
        Long groupMemberCount = memberRepository.countByGroup(group);
        return groupConverter.toDto(group, groupMemberCount);
    }
}
