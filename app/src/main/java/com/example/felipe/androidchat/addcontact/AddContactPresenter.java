package com.example.felipe.androidchat.addcontact;

import com.example.felipe.androidchat.addcontact.events.AddContactEvent;

public interface AddContactPresenter {
    void onShow();
    void onDestroy();

    void addContact(String email);
    void onEventMainThread(AddContactEvent event);
}
