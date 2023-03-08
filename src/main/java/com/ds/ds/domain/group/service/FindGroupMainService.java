package com.ds.ds.domain.group.service;

import com.ds.ds.domain.group.presentation.data.response.GroupMainResponse;

public interface FindGroupMainService {
    GroupMainResponse findGroupMain(Long groupIdx);
}
