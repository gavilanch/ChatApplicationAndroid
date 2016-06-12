package com.example.felipe.androidchat.login;

import android.util.Log;

import com.example.felipe.androidchat.domain.FirebaseHelper;
import com.example.felipe.androidchat.entities.User;
import com.example.felipe.androidchat.lib.EventBus;
import com.example.felipe.androidchat.lib.GreenRobotEventBus;
import com.example.felipe.androidchat.login.events.LoginEvent;
import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class LoginRepositoryImpl implements LoginRepository {

    private FirebaseHelper helper;
    private Firebase dataReference;
    private Firebase myUserReference;

    public LoginRepositoryImpl() {
        this.helper = FirebaseHelper.getInstance();
        this.dataReference = helper.getDataReference();
        this.myUserReference = helper.getMyUserReference();
    }

    @Override
    public void signUp(String email, String password) {
        postEvent(LoginEvent.onSignUpSuccess);

    }

    @Override
    public void signIn(String email, String password) {
        dataReference.authWithPassword(email, password, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                myUserReference = helper.getMyUserReference();


                myUserReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User currentUser = dataSnapshot.getValue(User.class);

                        if (currentUser != null){
                            String email = helper.getAuthUserEmail();
                            if (email != null){
                                currentUser = new User();
                                myUserReference.setValue(currentUser);
                            }
                        }
                        helper.changeUserConnectionStatus(User.ONLINE);
                        postEvent(LoginEvent.onSignInSuccess);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {}
                });

            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                postEvent(LoginEvent.onSignInError, firebaseError.getMessage());
            }
        });

    }

    @Override
    public void checkSession() {
      postEvent(LoginEvent.onFailedToRecoverSession);
    }

    private void postEvent(int type, String errorMessage){
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setEventType(type);
        if (errorMessage != null){
            loginEvent.setErrorMessage(errorMessage);
        }

        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(loginEvent);

    }

    private void postEvent(int type){
        postEvent(type, null);
    }
}
