package com.ds.ds.domain.group.service.impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.repository.GroupRepository;
import com.ds.ds.domain.group.exception.GroupNotFoundException;
import com.ds.ds.domain.group.presentation.data.dto.UpdateGroupDto;
import com.ds.ds.domain.group.service.UpdateGroupService;
import com.ds.ds.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateGroupServiceImpl implements UpdateGroupService {
    private final GroupRepository groupRepository;
    @Override
    @Transactional
    public void updateGroup(Long groupIdx, UpdateGroupDto updateGroupDto) {
        Group group = groupRepository.findById(groupIdx)
                .orElseThrow(() -> new GroupNotFoundException(ErrorCode.GROUP_NOT_FOUND));

        group.updateGroup(updateGroupDto);
        if(updateGroupDto.getSecret()){

        }
    }
}
