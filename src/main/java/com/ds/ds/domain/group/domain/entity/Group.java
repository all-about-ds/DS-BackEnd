package com.ds.ds.domain.group.domain.entity;

import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.global.common.entity.BaseIdEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Group extends BaseIdEntity {
    @Column(name = "GROUP_NAME",nullable = false,columnDefinition = "TEXT")
    private String title;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String groupDescription;

    private String groupImg;

    @Column
    private Long groupMaxCount;

    @Column(nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Builder
    public Group(String title,String groupDescription, String groupImg, Long groupMaxCount, String password) {
        this.title = title;
        this.groupDescription = groupDescription;
        this.groupImg = groupImg;
        this.groupMaxCount = groupMaxCount;
        this.password = password;
    }

}
