package com.ds.ds.global.common.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@MappedSuperclass
public abstract class BaseIdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
}