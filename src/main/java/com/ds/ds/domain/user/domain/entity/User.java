package com.ds.ds.domain.user.domain.entity;

import com.ds.ds.global.common.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseIdEntity {
    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_profile_image")
    private String profileImg;

    @Builder
    public User(String name, String email, String password, String profileImg) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.profileImg = profileImg;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
