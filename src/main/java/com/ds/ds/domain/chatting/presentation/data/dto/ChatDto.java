package com.ds.ds.domain.chatting.presentation.data.dto;

import com.ds.ds.domain.member.domain.entity.Member;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatDto {
    private Long id;
    private Long chatRoomId;
    private List<Long> members;
}
