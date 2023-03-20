package com.ds.ds.domain.timer.schedule;

import com.ds.ds.domain.timer.service.UpdateTimerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TimerSchedule {
    private final UpdateTimerService updateTimerService;

    @Scheduled(cron = "0 0 0 ? * MON-SUN")
    public void timerReset() {
        updateTimerService.updateTimer();
    }
}
