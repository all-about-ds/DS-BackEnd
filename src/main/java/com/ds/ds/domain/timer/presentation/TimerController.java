package com.ds.ds.domain.timer.presentation;

import com.ds.ds.domain.timer.presentation.data.request.StopTimerRequest;
import com.ds.ds.domain.timer.service.StartTimerService;
import com.ds.ds.domain.timer.service.StopTimerService;
import com.ds.ds.domain.timer.util.TimerConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/timer")
public class TimerController {
    private final StartTimerService startTimerService;
    private final StopTimerService stopTimerService;
    private final TimerConverter timerConverter;

    @PatchMapping("/start")
    public ResponseEntity<Void> startTimer() {
        startTimerService.startTimer();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/stop")
    public ResponseEntity<Void> stopTimer(@RequestBody StopTimerRequest request) {
        stopTimerService.stopTimer(timerConverter.toDto(request));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

