package com.example.felipe.androidchat.lib;

public class GreenRobotEventBus implements EventBus {

    org.greenrobot.eventbus.EventBus eventBus;

    private static class SingletonHolder{
        private static final GreenRobotEventBus INSTANCE = new GreenRobotEventBus();
    }

    public  static GreenRobotEventBus getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public GreenRobotEventBus(){
        this.eventBus = org.greenrobot.eventbus.EventBus.getDefault();
    }

    @Override
    public void register(Object suscriber) {
        eventBus.register(suscriber);
    }

    @Override
    public void unregister(Object suscriber) {
        eventBus.unregister(suscriber);
    }

    @Override
    public void post(Object event) {
        eventBus.post(event);
    }
}
