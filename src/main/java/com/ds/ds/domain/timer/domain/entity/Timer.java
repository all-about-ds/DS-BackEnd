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

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Timer extends BaseIdEntity {
    @Column(name = "timer")
    private Long timer;
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

    public void updateActivity(Boolean activity) {
        this.activity = activity;
    }

    public void updateTime(Long time) {
        this.timer = time;
    }
    public void initializeTime() { this.timer = 0L; }

    @Builder
    public Timer(Long timer, Boolean activity, User user, Group group){
        this.timer = timer;
        this.activity = activity;
        this.user = user;
        this.group = group;
    }
}
