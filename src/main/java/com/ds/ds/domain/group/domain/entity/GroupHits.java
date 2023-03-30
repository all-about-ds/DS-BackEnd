package com.ds.ds.domain.group.domain.entity;

import com.ds.ds.global.common.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity(name = "ds_group_hits")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupHits extends BaseIdEntity {
    private Long hits;

    @OneToOne(mappedBy = "ds_group_hits")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Group group;

    @Builder
    public GroupHits(Long hits, Group group){
        this.hits = hits;
        this.group = group;
    }
}
