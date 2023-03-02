package com.ds.ds.domain.group.presentation.data.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PageableDefault;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Getter
@Builder
@RequiredArgsConstructor
public class GroupListRequest {
    @NotNull
    private final Integer Size;
    @NotNull
    private final Integer page;
    @NotNull
    private final Optional<String> keyword;
}
