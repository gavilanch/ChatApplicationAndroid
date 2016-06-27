package com.example.felipe.androidchat.chat.ui;

import com.example.felipe.androidchat.entities.ChatMessage;

public interface ChatView {
    void onMessageReceived(ChatMessage msg);
}
