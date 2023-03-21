package com.ds.ds.domain.user.presentation.data.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateUserNameRequest {
    private String name;

    @JsonCreator
    public UpdateUserNameRequest(@JsonProperty("name") String name) {
        this.name = name;
    }
}
