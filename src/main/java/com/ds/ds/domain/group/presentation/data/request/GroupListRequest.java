package com.ds.ds.domain.group.presentation.data.request;

import lombok.*;
import org.springframework.data.web.PageableDefault;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public class GroupListRequest {
    @NotNull
    private final Integer Size;
    @NotNull
    private final Integer page;
    @NotNull
    private final Optional<String> keyword;
}
