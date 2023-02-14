package com.ds.ds.domain.group.domain.entity;

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
public class Group extends BaseIdEntity {
    @Column(name = "group_name", nullable = false,columnDefinition = "TEXT")
    private String groupName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String groupDescription;
    @Column(name = "group_image")
    private String groupImg;

    @Column(name = "group_max_count")
    private Long groupMaxCount;

    @Column(nullable = true)
    private String password;

    private boolean secret;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Group(String groupName, String groupDescription, String groupImg, Long groupMaxCount, String password) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.groupImg = groupImg;
        this.groupMaxCount = groupMaxCount;
        this.password = password;
    }

}
