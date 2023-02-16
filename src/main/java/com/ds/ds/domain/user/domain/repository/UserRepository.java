package com.ds.ds.domain.user.domain.repository;

import com.ds.ds.domain.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
