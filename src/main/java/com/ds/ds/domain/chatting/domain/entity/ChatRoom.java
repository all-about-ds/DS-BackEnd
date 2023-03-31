package com.ds.ds.domain.chatting.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ds.ds.domain.chatting.presentation.data.dto.UserIdDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoom implements Serializable {

    @Id
    @Column(name = "chatroom_id")
    private String id;
    private String name;
    private String profileImg;

    public ChatRoom(String name, String profileImg) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.profileImg = profileImg;
    }
}