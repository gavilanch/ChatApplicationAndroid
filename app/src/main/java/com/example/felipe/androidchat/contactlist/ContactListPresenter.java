package com.example.felipe.androidchat.contactlist;

import com.example.felipe.androidchat.contactlist.events.ContactListEvent;

public interface ContactListPresenter {

    void onCreate();
    void onDestroy();
    void onPause();
    void onResume();

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void onEventMainThread(ContactListEvent event);

}
