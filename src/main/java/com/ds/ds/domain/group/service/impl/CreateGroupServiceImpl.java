package com.ds.ds.domain.group.service.impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.entity.GroupHits;
import com.ds.ds.domain.group.domain.repository.GroupRepository;
import com.ds.ds.domain.group.domain.repository.GroupSecretRepository;
import com.ds.ds.domain.group.presentation.data.dto.CreateGroupDto;
import com.ds.ds.domain.group.service.CreateGroupService;
import com.ds.ds.domain.group.util.GroupConverter;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateGroupServiceImpl implements CreateGroupService {
    private final GroupRepository groupRepository;
    private final GroupConverter groupConverter;
    private final GroupSecretRepository groupSecretRepository;
    private final UserUtil userUtil;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createGroup(CreateGroupDto dto) {
        User user = userUtil.currentUser();
        GroupHits groupHits = new GroupHits(0L);
        Group group = groupConverter.toEntity(dto, user, groupHits);


        groupRepository.save(group);

        if(dto.getSecret()) {
            groupSecretRepository.save(groupConverter.toEntity(group, dto.getPassword().get()));
        }
    }
}
