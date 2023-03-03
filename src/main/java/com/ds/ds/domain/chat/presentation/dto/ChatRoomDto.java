package com.ds.ds.domain.chat.presentation.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomDto {
    @NotNull
    private String roomId;
    private String roomName;
    private int userCount;
    private int maxUserCount;

    private String roomPwd;
    private boolean secretChk;
    public enum ChatType{
        MSG,RTC
    }
    private ChatType chatType;

    public ConcurrentMap<String, ?>userList = new ConcurrentHashMap<>();
}
