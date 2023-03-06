package com.ds.ds.domain.chat.presentation.dto;

import com.ds.ds.domain.chat.rtc.KurentoUserSession;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.kurento.client.KurentoClient;
import org.kurento.client.MediaPipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.util.concurrent.ConcurrentMap;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class KurentoRoomDto extends ChatRoomDto implements Closeable {
    //로깅 객체생성
    private final Logger logger = LoggerFactory.getLogger(KurentoRoomDto.class);

    private KurentoClient kurento;

    private MediaPipeline pipeline;

    @NotNull
    private String roomId;
    private String roomName;
    private int userCount;
    private int maxUserCnt;

    private String roomPwd;
    private boolean secretChk;
    private ChatType chatType;

    private ConcurrentMap<String, KurentoUserSession> participants;

    //룸 정보
    public void setRoomInfo(String roomId, String roomName, boolean secure, int userCount, int maxUserCnt, ChatType chatType, KurentoClient kurento){
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomPwd = roomPwd;
        this.secretChk = secure;
        this.userCount = userCount;
        this.maxUserCnt = maxUserCnt;
        this.chatType = chatType;
        this.kurento = kurento;
        this.participants = (ConcurrentMap<String, KurentoUserSession>) this.userList;
    }
    public String getRoomId(){
        return roomId;
    }
}

