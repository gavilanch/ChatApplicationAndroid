package com.example.felipe.androidchat.contactlist.ui;

import com.example.felipe.androidchat.entities.User;

public interface ContactListView {
    void onContactAdded(User user);
    void onContactChanged(User user);
    void onContactRemoved(User user);
}
