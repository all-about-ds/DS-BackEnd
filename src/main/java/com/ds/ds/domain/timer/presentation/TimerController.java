package com.ds.ds.domain.timer.presentation;

import com.ds.ds.domain.timer.service.StartTimerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/timer")
public class TimerController {
    private final StartTimerService startTimerService;

    @PatchMapping("/start")
    public ResponseEntity<Void> startTimer() {
        startTimerService.startTimer();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

