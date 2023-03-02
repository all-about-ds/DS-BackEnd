package com.ds.ds.domain.group.presentation;

import com.ds.ds.domain.group.service.FindGroupListService;
import com.ds.ds.domain.group.util.GroupConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gruop")
public class GroupController {
    private final GroupConverter groupConverter;
    private final FindGroupListService findGroupListService;

}
