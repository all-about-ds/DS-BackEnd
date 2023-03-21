package com.ds.ds.domain.user.presentation.data.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateUserProfileImgRequest {
    private String updateUserProfile;

    @JsonCreator
    public UpdateUserProfileImgRequest(@JsonProperty("updateUserProfile") String updateUserProfile) {
        this.updateUserProfile = updateUserProfile;
    }
}
