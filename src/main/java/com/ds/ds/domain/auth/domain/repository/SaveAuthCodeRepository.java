package com.ds.ds.domain.auth.domain.repository;

import com.ds.ds.domain.auth.domain.entity.SaveAuthCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaveAuthCodeRepository extends JpaRepository<SaveAuthCode, String> {
}
