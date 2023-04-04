package com.ds.ds.domain.group.domain.entity;

import com.ds.ds.global.common.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "ds_group_hits")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupHits extends BaseIdEntity {
    private Long hits;

    @Builder
    public GroupHits(Long hits) {
        this.hits = hits;
    }

    public void updateHits() {
        ++this.hits;
    }
}
