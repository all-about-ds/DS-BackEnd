package com.ds.ds.domain.timer.domain.entity;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.global.common.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Timer extends BaseIdEntity {
    @Column(name = "timer")
    private LocalTime timer;
    @Column(name = "activity")
    private Boolean activity;

    @OneToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "group_id")
    private Group group;

    @Builder
    public Timer( LocalTime timer) {
        this.timer = timer;
    }
    public void updateActivity(Boolean activity) {
        this.activity = activity;
    }

    public void updateTime(LocalTime time) {
        this.timer = time;
    }
}
