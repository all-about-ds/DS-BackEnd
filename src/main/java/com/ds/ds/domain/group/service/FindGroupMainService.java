package com.ds.ds.domain.group.service;

import com.ds.ds.domain.group.presentation.data.dto.GroupMainDto;

public interface FindGroupMainService {
    GroupMainDto findGroupMain(Long groupIdx);
}
