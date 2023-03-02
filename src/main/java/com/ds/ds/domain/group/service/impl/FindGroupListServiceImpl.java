package com.ds.ds.domain.group.service.impl;

import com.ds.ds.domain.group.presentation.data.dto.GroupListDto;
import com.ds.ds.domain.group.service.FindGroupListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindGroupListServiceImpl implements FindGroupListService {
    @Override
    public List<GroupListDto> findGroupList() {
        return null;
    }
}
