package com.ds.ds.domain.group.presentation.data.request;

import lombok.*;
import org.springframework.data.web.PageableDefault;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Getter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class GroupListRequest {
    @NotNull
    private Integer Size;
    @NotNull
    private Integer page;
    @NotNull
    private Optional<String> keyword;
}
