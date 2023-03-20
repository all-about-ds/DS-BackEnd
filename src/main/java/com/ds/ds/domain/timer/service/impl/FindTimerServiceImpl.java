package com.ds.ds.domain.timer.service.impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.repository.GroupRepository;
import com.ds.ds.domain.group.exception.GroupNotFoundException;
import com.ds.ds.domain.timer.domain.entity.Timer;
import com.ds.ds.domain.timer.domain.repository.TimerRepository;
import com.ds.ds.domain.timer.presentation.data.dto.TimerDto;
import com.ds.ds.domain.timer.service.FindTimerService;
import com.ds.ds.domain.timer.util.TimerConverter;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.util.UserUtil;
import com.ds.ds.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class, readOnly = true)
@RequiredArgsConstructor
public class FindTimerServiceImpl implements FindTimerService {
    private final UserUtil userUtil;
    private final GroupRepository groupRepository;
    private final TimerRepository timerRepository;
    private final TimerConverter timerConverter;

    @Override
    public TimerDto findTimer(Long groupIdx) {
        User user = userUtil.currentUser();
        Group group = groupRepository.findById(groupIdx).orElseThrow(()-> new GroupNotFoundException(ErrorCode.GROUP_NOT_FOUND));
        List<Timer> timerList = timerRepository.findAllByGroup(group);
        Timer userTimer = timerRepository.findByUser(user);

        List<TimerDto.MemberTimerDto> filteredTimer = timerList.stream()
                .filter(timer -> timer.getUser().getIdx() != user.getIdx())
                .map(it -> timerConverter.toDto(it))
                .collect(Collectors.toList());

        return timerConverter.toDto(userTimer, filteredTimer);
    }
}
