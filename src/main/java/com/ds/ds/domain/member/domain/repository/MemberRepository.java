package com.ds.ds.domain.member.domain.repository;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.member.domain.entity.Member;
import com.ds.ds.domain.user.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {
    Long countByGroup(Group group);
    List<Member> findMemberByGroup(Group group);
    List<Member> findMemberByUser(User user);
    Boolean existsByUser(User user);
    boolean existsByUserAndGroup(User user, Group group);
    void deleteByUserAndGroup(User user, Group group);
    void deleteByUserIdxAndGroupIdx(Long idx, Long groupIdx);
    boolean existsByUserIdxAndGroupIdx(Long idx, Long groupIdx);
}
