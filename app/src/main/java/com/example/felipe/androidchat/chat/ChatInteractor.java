package com.example.felipe.androidchat.chat;

import com.example.felipe.androidchat.entities.ChatMessage;

public interface ChatInteractor {

    void setChatRecipient(String recipient);
    void sendMessage(String msg);
    void subscribe();
    void unsubscribe();
    void destroyListener();
}
