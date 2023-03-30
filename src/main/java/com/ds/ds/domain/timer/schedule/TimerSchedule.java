package com.ds.ds.domain.timer.schedule;

import com.ds.ds.domain.timer.service.InitializeTimerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TimerSchedule {
    private final InitializeTimerService initializeTimerService;

    @Scheduled(cron = "0 0 0 ? * MON-SUN")
    public void timerReset() {
        initializeTimerService.updateTimer();
    }
}
