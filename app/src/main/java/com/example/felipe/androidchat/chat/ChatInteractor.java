package com.example.felipe.androidchat.chat;

import com.example.felipe.androidchat.entities.ChatMessage;

public interface ChatInteractor {

    void setChatRecipient(String recipient);
    void sendMessage(ChatMessage msg);
    void subscribe();
    void unsubscribe();
    void destroyListener();
}
