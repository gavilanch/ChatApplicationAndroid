package com.example.felipe.androidchat.contactlist;

import com.example.felipe.androidchat.contactlist.events.ContactListEvent;
import com.example.felipe.androidchat.contactlist.ui.adapters.ContactListAdapter;
import com.example.felipe.androidchat.domain.FirebaseHelper;
import com.example.felipe.androidchat.entities.User;
import com.example.felipe.androidchat.lib.EventBus;
import com.example.felipe.androidchat.lib.GreenRobotEventBus;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class ContactListRepositoryImpl implements ContactListRepository {

    private  EventBus eventBus;
    private FirebaseHelper helper;
    private ChildEventListener contactEventListener;


    public ContactListRepositoryImpl() {
        this.helper = FirebaseHelper.getInstance();
    this.eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void signOff() {
        helper.signOff();
    }

    @Override
    public String getCurrentUserEmail() {
        return helper.getAuthUserEmail();
    }

    @Override
    public void removeContact(String email) {
        String currentUserEmail = helper.getAuthUserEmail();
        helper.getOneContactReference(currentUserEmail, email).removeValue();
        helper.getOneContactReference(email, currentUserEmail).removeValue();
    }

    @Override
    public void destroyListener() {
        contactEventListener = null;
    }

    @Override
    public void subscribeToContactListEvents() {
        if (contactEventListener == null) {
            contactEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    handleContact(dataSnapshot, ContactListEvent.onContactAdded);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    handleContact(dataSnapshot, ContactListEvent.onContactChanged);
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    handleContact(dataSnapshot, ContactListEvent.onContactRemoved);
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            };
        }
        helper.getMyContactsReference().addChildEventListener(contactEventListener);
    }

    private void handleContact(DataSnapshot dataSnapshot, int type) {
        String email = dataSnapshot.getKey();
        email = email.replace("_", ".");
        boolean online = ((Boolean)dataSnapshot.getValue());
        User user = new User();
        user.setEmail(email);
        user.setOnline(online);
        post(type, user);

    }

    private void post(int type, User user) {
        ContactListEvent event = new ContactListEvent();
        event.setEventType(type);
        event.setUser(user);
        eventBus.post(event);
    }


    @Override
    public void unsubscribeToContactListEvents() {
        if (contactEventListener != null){
           Firebase contactsReference = helper.getMyContactsReference();
            if (contactsReference != null){
                contactsReference.removeEventListener(contactEventListener);
            }
        }
    }

    @Override
    public void changeConnectionStatus(boolean online) {

    }
}
