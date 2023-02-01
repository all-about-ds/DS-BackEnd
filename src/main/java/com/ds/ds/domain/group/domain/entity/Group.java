package com.ds.ds.domain.group.domain.entity;

import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.global.common.entity.BaseIdEntity;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
public class Group extends BaseIdEntity {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String groupDescription;

    private String groupImg;

    @Column
    private Long groupMaxCount;

    @Column
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Builder
    public Group(String groupDescription, String groupImg, Long groupMaxCount, String password) {
        this.groupDescription = groupDescription;
        this.groupImg = groupImg;
        this.groupMaxCount = groupMaxCount;
        this.password = password;
    }

}
