package com.example.felipe.androidchat;

import android.app.Application;

import com.firebase.client.Firebase;

public class AndroidClassApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        setupFireBase();
    }

    private void setupFireBase() {
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }
}
