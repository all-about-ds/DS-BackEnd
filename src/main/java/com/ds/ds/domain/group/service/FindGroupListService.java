package com.ds.ds.domain.group.service;

import com.ds.ds.domain.group.presentation.data.dto.GroupInfoDto;

import java.util.List;

public interface FindGroupListService {
    List<GroupInfoDto> findGroupList();
}
