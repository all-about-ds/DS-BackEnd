package com.ds.ds.domain.group.domain.repository;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.user.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface GroupRepository extends JpaRepository<Group, Long> {
    Page<Group> findAll(Pageable pageable);
    Page<Group> findAllByGroupNameContaining(Pageable pageable, String groupName);
    List<Group> findByUser(User user);
    Boolean existsByUser(User user);
}
