package com.ds.ds.domain.group.service.impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.repository.GroupRepository;
import com.ds.ds.domain.group.presentation.data.dto.GroupDto;
import com.ds.ds.domain.group.presentation.data.dto.GroupListDto;
import com.ds.ds.domain.group.presentation.data.dto.GroupListSearchRequirementDto;
import com.ds.ds.domain.group.service.FindGroupListService;
import com.ds.ds.domain.group.util.GroupConverter;
import com.ds.ds.domain.member.domain.repository.MemberRepository;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindGroupListServiceImpl implements FindGroupListService {
    private final GroupRepository groupRepository;
    private final MemberRepository memberRepository;
    private final GroupConverter groupConverter;
    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public GroupListDto findGroupList(GroupListSearchRequirementDto dto) {
        List<GroupDto> groups = getGroupList(dto).stream()
                .map(group -> groupConverter.toDto(memberRepository.countByGroup(group)+1, group))
                .collect(Collectors.toList());

       return groupConverter.toDto(dto.getPageable(), groups);
    }
    private List<Group> getGroupList(GroupListSearchRequirementDto dto) {
        if(dto.getKeyword().isEmpty()) {
           return groupRepository.findAll(dto.getPageable()).toList();
        } else {
           return groupRepository.findAllByGroupNameContaining(dto.getPageable(), dto.getKeyword().get()).toList();
        }
    }
}
