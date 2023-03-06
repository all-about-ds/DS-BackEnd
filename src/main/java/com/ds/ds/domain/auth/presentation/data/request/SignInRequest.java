package com.ds.ds.domain.auth.presentation.data.request;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class SignInRequest {
    private String email;
    private String password;
}
