package com.ds.ds.domain.timer.domain.repository;

import com.ds.ds.domain.timer.domain.entity.Timer;
import com.ds.ds.domain.user.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface TimerRepository extends CrudRepository<Timer, Long> {
    Timer findByUser(User user);
}
