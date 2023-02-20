package com.ds.ds.domain.auth.domain.repository;

import com.ds.ds.domain.auth.domain.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
}
