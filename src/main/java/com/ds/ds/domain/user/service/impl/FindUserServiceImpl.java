package com.ds.ds.domain.user.service.impl;

import com.ds.ds.domain.group.domain.entity.Group;
import com.ds.ds.domain.group.domain.repository.GroupRepository;
import com.ds.ds.domain.member.domain.repository.MemberRepository;
import com.ds.ds.domain.user.domain.entity.User;
import com.ds.ds.domain.user.presentation.data.dto.UserDto;
import com.ds.ds.domain.user.service.FindUserService;
import com.ds.ds.domain.user.util.UserConverter;
import com.ds.ds.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ListUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class FindUserServiceImpl implements FindUserService {
    private final UserUtil userUtil;
    private final GroupRepository groupRepository;
    private final MemberRepository memberRepository;
    private final UserConverter userConverter;

    @Override
    public UserDto findUser() {
        User user = userUtil.currentUser();

        List<UserDto.GroupDto> group = groupRepository.findByUser(user).stream()
                .map(it -> userConverter.toDto(it))
                .collect(Collectors.toList());
        List<UserDto.GroupDto> memberGroup = memberRepository.findMemberByUser(user).stream()
                .map(member -> userConverter.toDto(member.getGroup()))
                .collect(Collectors.toList());

        List<UserDto.GroupDto> userGroupList = Stream.concat(group.stream(), memberGroup.stream())
                .collect(Collectors.toList());

        return userConverter.toDto(user, userGroupList);
    }
}
