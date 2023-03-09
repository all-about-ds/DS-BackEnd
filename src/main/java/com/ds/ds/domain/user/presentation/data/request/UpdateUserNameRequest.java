package com.ds.ds.domain.user.presentation.data.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateUserNameRequest {
    private final String name;
}
