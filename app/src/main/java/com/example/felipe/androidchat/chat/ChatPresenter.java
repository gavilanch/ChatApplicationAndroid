package com.example.felipe.androidchat.chat;

import com.example.felipe.androidchat.chat.events.ChantEvent;
import com.example.felipe.androidchat.entities.ChatMessage;

public interface ChatPresenter {
    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void setChatRecipient(String recipient);
    void sendMessage(ChatMessage msg);
    void onEventMainThread(ChantEvent event);
}
