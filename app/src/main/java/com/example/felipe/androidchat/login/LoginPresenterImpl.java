package com.example.felipe.androidchat.login;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void checkForAuthenticatedUser() {
        setViewInWaitMode();
        loginInteractor.checkSession();
    }

    @Override
    public void validateLogin(String email, String password) {
        setViewInWaitMode();
        loginInteractor.doSignIn(email, password);
    }

    @Override
    public void registerNewUser(String email, String password) {
        setViewInWaitMode();
        loginInteractor.doSignUp(email, password);
    }

    private void setViewInWaitMode(){
        if (loginView != null){
            loginView.disableInputs();
            loginView.showProgress();
        }
    }

    private void onSignInSuccess(){
        if (loginView != null){
            loginView.navigateToMainScreen();
        }
    }

    private void onSignUpSuccess(){
        if (loginView != null){
            loginView.newUserSuccess();
        }
    }

    private void onSignInError(String error){
        if (loginView != null){
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.loginError(error);
        }
    }

    private void onSignUpError(String error){
        if (loginView != null){
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.newUserError(error);
        }
    }
}
