package com.ds.ds.domain.timer.service.impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.repository.GroupRepository;
import com.ds.ds.domain.group.exception.GroupNotFoundException;
import com.ds.ds.domain.timer.domain.entity.Timer;
import com.ds.ds.domain.timer.domain.repository.TimerRepository;
import com.ds.ds.domain.timer.presentation.data.dto.TimerDto;
import com.ds.ds.domain.timer.service.FindTimerService;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.util.UserUtil;
import com.ds.ds.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindTimerServiceImpl implements FindTimerService {
    private final UserUtil userUtil;
    private final GroupRepository groupRepository;
    private final TimerRepository timerRepository;

    @Override
    public TimerDto findTimer(Long groupIdx) {
        User user = userUtil.currentUser();
        Group group = groupRepository.findById(groupIdx).orElseThrow(()-> new GroupNotFoundException(ErrorCode.GROUP_NOT_FOUND));
        List<Timer> timerList = timerRepository.findAllByGroup(group);

        return null;
    }
}
