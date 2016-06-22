package com.example.felipe.androidchat.addcontact;

public class AddContactInteractorImpl implements AddContactInteractor {
    private AddContactRepository repository;

public  AddContactInteractorImpl(){
    repository = new AddContactRepositoryImpl();
}

    @Override
    public void addContact(String email) {
        repository.addContact(email);
    }
}
