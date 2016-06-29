package com.example.felipe.androidchat.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"sentByMe"})
public class ChatMessage {
    private String msg;
    private String sender;
    private Boolean sentByMe;

    public ChatMessage() {

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Boolean getSentByMe() {
        return sentByMe;
    }

    public void setSentByMe(Boolean sentByMe) {
        this.sentByMe = sentByMe;
    }

    @Override
    public boolean equals(Object object){
        boolean equal = false;

        if (object instanceof User){
            ChatMessage message = (ChatMessage)object;
            equal = this.sender.equals(message.getSender()) && this.msg.equals(message.getMsg()) && this.sentByMe == message.getSentByMe();
        }

        return equal;
    }
}
