package com.example.felipe.androidchat.chat;

public class ChatSessionInteractorImpl implements ChatSessionInteractor {
    ChatRepository chatRepository;

    public ChatSessionInteractorImpl() {
        this.chatRepository = new ChatRepositoryImpl();
    }

    @Override
    public void changeConnectionStatus(boolean online) {
        chatRepository.changeConnectionStatus(online);
    }
}
