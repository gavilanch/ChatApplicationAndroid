package com.example.felipe.androidchat.login;

import android.util.Log;

import com.example.felipe.androidchat.domain.FirebaseHelper;

public class LoginRepositoryImpl implements LoginRepository {

    private FirebaseHelper helper;

    public LoginRepositoryImpl() {
        this.helper = FirebaseHelper.getInstance();
    }

    @Override
    public void signUp(String email, String password) {
        Log.e("LoginRepositoryImpl", "signup");
    }

    @Override
    public void signIn(String email, String password) {
        Log.e("LoginRepositoryImpl", "signin");
    }

    @Override
    public void checkSession() {
        Log.e("LoginRepositoryImpl", "checkSession");
    }
}
