package com.ds.ds.domain.timer.domain.repository;

import com.ds.ds.domain.timer.domain.entity.Timer;
import org.springframework.data.repository.CrudRepository;

public interface TimerRepository extends CrudRepository<Timer, Long> {
}
