package com.ds.ds.domain.group.service;

import com.ds.ds.domain.group.presentation.data.dto.GroupListSearchRequirementDto;
import com.ds.ds.domain.group.presentation.data.dto.PopularityGroupListDto;

public interface FindPopularityGroupService {
    PopularityGroupListDto findPopularityGroupList(GroupListSearchRequirementDto toDto);
}
