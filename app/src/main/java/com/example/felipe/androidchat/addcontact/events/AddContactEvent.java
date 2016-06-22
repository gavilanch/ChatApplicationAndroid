package com.example.felipe.androidchat.addcontact.events;

public class AddContactEvent {
    private boolean error = false;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
