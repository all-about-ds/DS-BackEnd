package com.ds.ds.domain.group.service;

import com.ds.ds.domain.group.presentation.data.dto.JoinGroupDto;

public interface JoinGroupService {
    void joinGroup(JoinGroupDto joinGroupDto, Long groupIdx);
}
