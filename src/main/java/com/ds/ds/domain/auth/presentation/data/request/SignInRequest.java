package com.ds.ds.domain.auth.presentation.data.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@RequiredArgsConstructor
public class SignInRequest {
    private final String email;
    private final String password;
}

