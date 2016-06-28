package com.example.felipe.androidchat.chat;

import com.example.felipe.androidchat.entities.ChatMessage;

public class ChatInteractorImpl implements ChatInteractor {

    ChatRepository chatRepository;

    public ChatInteractorImpl() {
        this.chatRepository = new ChatRepositoryImpl();
    }

    @Override
    public void setChatRecipient(String recipient) {
        chatRepository.setChatRecipient(recipient);
    }

    @Override
    public void sendMessage(ChatMessage msg) {
        chatRepository.sendMessage(msg);
    }

    @Override
    public void subscribe() {
        chatRepository.subscribe();
    }

    @Override
    public void unsubscribe() {
        chatRepository.unsubscribe();
    }

    @Override
    public void destroyListener() {
        chatRepository.destroyListener();
    }
}
