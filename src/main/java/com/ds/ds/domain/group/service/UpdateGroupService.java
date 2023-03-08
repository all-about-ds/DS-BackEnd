package com.ds.ds.domain.group.service;

import com.ds.ds.domain.group.presentation.data.dto.UpdateGroupDto;

public interface UpdateGroupService {
    void updateGroup(Long groupIdx, UpdateGroupDto updateGroupDto);
}
