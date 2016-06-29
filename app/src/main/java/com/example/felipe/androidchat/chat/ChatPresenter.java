package com.example.felipe.androidchat.chat;

import com.example.felipe.androidchat.chat.events.ChatEvent;
import com.example.felipe.androidchat.entities.ChatMessage;

public interface ChatPresenter {
    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void setChatRecipient(String recipient);
    void sendMessage(String msg);
    void onEventMainThread(ChatEvent event);
}
