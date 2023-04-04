package com.ds.ds.domain.group.event.handler;

import com.ds.ds.domain.group.domain.entity.GroupHits;
import com.ds.ds.domain.group.domain.repository.GroupHitsRepository;
import com.ds.ds.domain.group.event.SawGroupDetailEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class GroupHitsHandler {
    private final GroupHitsRepository groupHitsRepository;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateGroupHits(SawGroupDetailEvent event) {
        GroupHits groupHits = event.getGroupHits();
        groupHits.updateHits();
        groupHitsRepository.save(groupHits);
    }
}
