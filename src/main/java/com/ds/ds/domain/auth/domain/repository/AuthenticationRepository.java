package com.ds.ds.domain.auth.domain.repository;

import com.ds.ds.domain.auth.domain.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository extends JpaRepository<Authentication, String> {
}
