package com.example.felipe.androidchat.addcontact;

import com.example.felipe.androidchat.addcontact.events.AddContactEvent;
import com.example.felipe.androidchat.addcontact.ui.AddContactFragment;
import com.example.felipe.androidchat.addcontact.ui.AddContactView;

public class AddContactPresenterImpl implements AddContactPresenter {

    AddContactView view;

    public AddContactPresenterImpl(AddContactView addContactView) {
        this.view = view;
    }

    @Override
    public void onShow() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void addContact(String email) {

    }

    @Override
    public void onEventMainThread(AddContactEvent event) {

    }
}
