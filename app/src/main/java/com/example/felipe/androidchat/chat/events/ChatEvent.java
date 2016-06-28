package com.example.felipe.androidchat.chat.events;

import com.example.felipe.androidchat.entities.ChatMessage;

public class ChatEvent {
     ChatMessage message;

    public ChatMessage getMessage() {
        return message;
    }

    public void setMessage(ChatMessage message) {
        this.message = message;
    }
}
