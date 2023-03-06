package com.ds.ds.domain.auth.service.Impl;

import com.ds.ds.domain.auth.presentation.data.dto.PasswordDto;
import com.ds.ds.domain.auth.presentation.data.dto.SearchPasswordDto;
import com.ds.ds.domain.auth.service.SearchPasswordService;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchPasswordServiceImpl implements SearchPasswordService {
    private final UserRepository userRepository;
    @Override
    public PasswordDto search(SearchPasswordDto searchPasswordDto) {
        if(!searchPasswordDto.getPassword().equals(searchPasswordDto.getCheckPassword())){
        }
    }
}
