package com.ds.ds.domain.group.service;

import com.ds.ds.domain.group.presentation.data.dto.GroupListDto;
import com.ds.ds.domain.group.presentation.data.dto.GroupListSearchRequirementDto;

import java.util.List;

public interface FindGroupListService {
    GroupListDto findGroupList(GroupListSearchRequirementDto dto);
}
