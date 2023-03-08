package com.ds.ds.domain.group.service.impl;

import com.ds.ds.domain.group.presentation.data.response.GroupMainResponse;
import com.ds.ds.domain.group.service.FindGroupMainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindGroupMainServiceImpl implements FindGroupMainService {
    @Override
    public GroupMainResponse findGroupMain(Long groupIdx) {
        return null;
    }
}
