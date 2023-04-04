package com.ds.ds.domain.group.service.impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.repository.GroupRepository;
import com.ds.ds.domain.group.presentation.data.dto.*;
import com.ds.ds.domain.group.service.FindPopularityGroupService;
import com.ds.ds.domain.group.util.GroupConverter;
import com.ds.ds.domain.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindPopularityGroupServiceImpl implements FindPopularityGroupService {
    private final GroupRepository groupRepository;
    private final MemberRepository memberRepository;
    private final GroupConverter groupConverter;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public PopularityGroupListDto findPopularityGroupList(GroupListSearchRequirementDto dto) {
        List<PopularityGroupDto> popularityGroups = getGroupList(dto).stream()
                .map(group -> groupConverter.toGroupDto(memberRepository.countByGroup(group)+1, group))
                .sorted(Comparator.comparing(PopularityGroupDto::getHits)).collect(Collectors.toList());

        return groupConverter.toGroupListDto(dto.getPageable(), popularityGroups);
    }
    private List<Group> getGroupList(GroupListSearchRequirementDto dto) {
        if(dto.getKeyword().isEmpty()) {
            return groupRepository.findAll(dto.getPageable()).toList();
        } else {
            return groupRepository.findAllByGroupNameContaining(dto.getPageable(), dto.getKeyword().get()).toList();
        }
    }
}
