package com.ds.ds.domain.group.service.impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.repository.GroupRepository;
import com.ds.ds.domain.group.presentation.data.dto.GroupDto;
import com.ds.ds.domain.group.presentation.data.dto.GroupListDto;
import com.ds.ds.domain.group.presentation.data.dto.GroupListSearchRequirementDto;
import com.ds.ds.domain.group.service.FindGroupListService;
import com.ds.ds.domain.group.util.GroupConverter;
import com.ds.ds.domain.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindGroupListServiceImpl implements FindGroupListService {
    private final GroupRepository groupRepository;
    private final MemberRepository memberRepository;
    private final GroupConverter groupConverter;
    @Override
    public GroupListDto findGroupList(GroupListSearchRequirementDto dto) {
        List<Group> groups;
        List<GroupDto> result = null;
        if(dto.getPageable() == null) {
            groups = groupRepository.findAll(dto.getPageable()).toList();
        } else {
            groups = groupRepository.findAllByGroupNameContaining(dto.getPageable(), dto.getKeyword().toString()).toList();
        }
        List<Long> groupsMemberCount = groups.stream()
                .map(it -> memberRepository.countByGroup(it))
                .collect(Collectors.toList());
       for(int i = 0; i <= groups.size(); i++) {
           result.add(groupConverter.toDto(groups.get(i), groupsMemberCount.get(i)));
       }
       return groupConverter.toDto(dto.getPageable(), result);
    }
}
