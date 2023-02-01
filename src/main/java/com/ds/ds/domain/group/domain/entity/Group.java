package com.ds.ds.domain.group.domain.entity;

import com.ds.ds.global.common.entity.BaseIdEntity;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

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


}
