package com.ds.ds.domain.auth.service;

import com.ds.ds.domain.auth.presentation.data.dto.PasswordDto;
import com.ds.ds.domain.auth.presentation.data.dto.SearchPasswordDto;

public interface SearchPasswordService {
    PasswordDto search(SearchPasswordDto searchPasswordDto);
}
