package com.ds.ds.domain.timer.service.impl;

import com.ds.ds.domain.timer.domain.entity.Timer;
import com.ds.ds.domain.timer.domain.repository.TimerRepository;
import com.ds.ds.domain.timer.presentation.data.dto.StopTimerDto;
import com.ds.ds.domain.timer.service.StopTimerService;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class StopTimerServiceImpl implements StopTimerService {
    private final UserUtil userUtil;
    private final TimerRepository timerRepository;

    @Override
    public void stopTimer(StopTimerDto dto) {
        User user = userUtil.currentUser();
        Timer userTimer = timerRepository.findByUser(user);

        userTimer.updateActivity(false);
        userTimer.updateTime(dto.getTime());

        timerRepository.save(userTimer);
    }
}
