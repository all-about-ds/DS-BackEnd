package com.ds.ds.domain.group.event;

import com.ds.ds.domain.group.domain.entity.GroupHits;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SawGroupDetailEvent {
    private final GroupHits groupHits;

    @Builder
    public SawGroupDetailEvent(GroupHits groupHits){
        this.groupHits = groupHits;
    }
}
