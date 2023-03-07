package com.ds.ds.domain.auth.domain.repository;

import com.ds.ds.domain.auth.domain.entity.AuthCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthCodeRepository extends JpaRepository<AuthCode, String> {
    Optional<AuthCode> findByEmail(String email);
}
