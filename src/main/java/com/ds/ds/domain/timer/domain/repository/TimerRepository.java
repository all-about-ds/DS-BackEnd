package com.ds.ds.domain.timer.domain.repository;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.timer.domain.entity.Timer;
import com.ds.ds.domain.user.domain.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TimerRepository extends CrudRepository<Timer, Long> {
    Timer findByUser(User user);
    List<Timer> findAllByGroup(Group group);
    List<Timer> findAll();
    @Modifying
    @Query("update Timer set timer = timer + 1 where activity = true")
    void updateTimer();
}
