package com.ds.ds.domain.member.domain.repository;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.member.domain.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
    Long countByGroup(Group group);
}
