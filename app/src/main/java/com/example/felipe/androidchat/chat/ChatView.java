package com.example.felipe.androidchat.chat;

import com.example.felipe.androidchat.entities.ChatMessage;

public interface ChatView {
    void onMessageReceived(ChatMessage msg);
}
