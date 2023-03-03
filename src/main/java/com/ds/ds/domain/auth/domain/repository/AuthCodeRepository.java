package com.ds.ds.domain.auth.domain.repository;

import com.ds.ds.domain.auth.domain.entity.AuthCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthCodeRepository extends JpaRepository<AuthCode, String> {
    AuthCode findByCode(String authCode);
}
