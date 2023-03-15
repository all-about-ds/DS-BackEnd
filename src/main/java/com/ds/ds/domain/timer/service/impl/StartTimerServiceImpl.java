package com.ds.ds.domain.timer.service.impl;

import com.ds.ds.domain.timer.domain.entity.Timer;
import com.ds.ds.domain.timer.domain.repository.TimerRepository;
import com.ds.ds.domain.timer.service.StartTimerService;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class StartTimerServiceImpl implements StartTimerService {
    private final UserUtil userUtil;
    private final TimerRepository timerRepository;

    @Override
    public void startTimer() {
        User user = userUtil.currentUser();
        Timer userTimer = timerRepository.findByUser(user);

        userTimer.updateActivity(true);

        timerRepository.save(userTimer);
    }
}
