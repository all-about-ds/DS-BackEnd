package com.ds.ds.domain.timer.domain.entity;

import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.global.common.entity.BaseIdEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Timer extends BaseIdEntity {
    @Column(nullable = false,columnDefinition = "TEXT")
    private String name;

    @Column
    private Integer timer;

    @Column
    private Integer myTimer;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
