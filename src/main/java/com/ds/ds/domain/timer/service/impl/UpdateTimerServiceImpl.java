package com.ds.ds.domain.timer.service.impl;

import com.ds.ds.domain.timer.domain.entity.Timer;
import com.ds.ds.domain.timer.domain.repository.TimerRepository;
import com.ds.ds.domain.timer.service.UpdateTimerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class UpdateTimerServiceImpl implements UpdateTimerService {
    private final TimerRepository timerRepository;

    @Override
    public void updateTimer() {
        List<Timer> timerList = timerRepository.findAll();

        timerList.stream()
                .forEach(timer -> timer.initializeTime());

        timerRepository.saveAll(timerList);
    }
}
