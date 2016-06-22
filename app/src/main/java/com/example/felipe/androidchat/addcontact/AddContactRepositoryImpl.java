package com.example.felipe.androidchat.addcontact;

import com.example.felipe.androidchat.addcontact.events.AddContactEvent;
import com.example.felipe.androidchat.domain.FirebaseHelper;
import com.example.felipe.androidchat.entities.User;
import com.example.felipe.androidchat.lib.EventBus;
import com.example.felipe.androidchat.lib.GreenRobotEventBus;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class AddContactRepositoryImpl implements AddContactRepository {

    private EventBus eventBus;
    private FirebaseHelper helder;

    public AddContactRepositoryImpl() {
        this.eventBus = GreenRobotEventBus.getInstance();
        this.helder = FirebaseHelper.getInstance();
    }

    @Override
    public void addContact(final String email) {
        final String key = email.replace(".", "_");
        Firebase userReference = helder.getUserReference(email);
        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);

                if (user != null){
                    Firebase myContactsReference = helder.getMyContactsReference();
                    myContactsReference.child(key).setValue(user.isOnline());

                    String currentUserKey = helder.getAuthUserEmail();
                    currentUserKey = currentUserKey.replace(".", "_");

                    Firebase reverseContactReference = helder.getContactsReference(email);
                    reverseContactReference.child(currentUserKey).setValue(User.ONLINE);

                    post(false);

                }
                else{
                    post(true);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                post(true);
            }
        });
    }

    private void post(boolean error) {
        AddContactEvent event = new AddContactEvent();
        event.setError(true);
        eventBus.post(event);
    }
}
