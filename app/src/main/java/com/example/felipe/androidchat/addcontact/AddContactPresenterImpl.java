package com.example.felipe.androidchat.addcontact;

import com.example.felipe.androidchat.addcontact.events.AddContactEvent;
import com.example.felipe.androidchat.addcontact.ui.AddContactFragment;
import com.example.felipe.androidchat.addcontact.ui.AddContactView;
import com.example.felipe.androidchat.lib.EventBus;
import com.example.felipe.androidchat.lib.GreenRobotEventBus;

import org.greenrobot.eventbus.Subscribe;

public class AddContactPresenterImpl implements AddContactPresenter {

    private EventBus eventBus;
    private AddContactInteractor interactor;
    private AddContactView view;

    public AddContactPresenterImpl(AddContactView addContactView) {
        this.view = addContactView;
        this.eventBus = GreenRobotEventBus.getInstance();
        this.interactor = new AddContactInteractorImpl();
    }

    @Override
    public void onShow() {
    eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        this.view = null;
        eventBus.unregister(this);
    }

    @Override
    public void addContact(String email) {
        if (view != null){
            view.hideInput();
            view.showProgress();
        }
        interactor.addContact(email);
    }

    @Override
    @Subscribe
    public void onEventMainThread(AddContactEvent event) {
        if (view != null){
            view.showInput();
            view.hideProgress();
        }

        if (event.isError()){
            view.contactNotAdded();
        } else{
            view.contactAdded();
        }

    }
}
