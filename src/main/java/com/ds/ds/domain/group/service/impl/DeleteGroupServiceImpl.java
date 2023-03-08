package com.ds.ds.domain.group.service.impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.repository.GroupRepository;
import com.ds.ds.domain.group.exception.GroupNotFoundException;
import com.ds.ds.domain.group.exception.NotBossException;
import com.ds.ds.domain.group.service.DeleteGroupService;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.util.UserUtil;
import com.ds.ds.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteGroupServiceImpl implements DeleteGroupService {
    private final GroupRepository groupRepository;
    private final UserUtil userUtil;
    @Override
    public void deleteGroup(Long groupIdx) {
        User user = userUtil.currentUser();
        Group group = groupRepository.findById(groupIdx)
                .orElseThrow(() -> new GroupNotFoundException(ErrorCode.GROUP_NOT_FOUND));

        if(group.getUser().getIdx().equals(user.getIdx())){
            groupRepository.delete(group);
        } else {
            throw new NotBossException(ErrorCode.NOT_BOSS);
        }
    }
}
