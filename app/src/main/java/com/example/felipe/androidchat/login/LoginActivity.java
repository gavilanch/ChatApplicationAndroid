package com.example.felipe.androidchat.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.felipe.androidchat.R;
import com.example.felipe.androidchat.contactlist.ContactListActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @Bind(R.id.txtEmail)
    EditText txtEmail;
    @Bind(R.id.txtPassword)
    EditText txtPassword;
    @Bind(R.id.wrapperPassword)
    TextInputLayout wrapperPassword;
    @Bind(R.id.btnSignIn)
    Button btnSignIn;
    @Bind(R.id.btnSignUp)
    Button btnSignUp;
    @Bind(R.id.layoutButtons)
    LinearLayout layoutButtons;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.layoutMainContainer)
    RelativeLayout layoutMainContainer;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnSignIn, R.id.btnSignUp})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignIn:
                break;
            case R.id.btnSignUp:
                break;
        }
    }

    @Override
    public void enableInputs() {
        setInputs(true);
    }

    @Override
    public void disableInputs() {
        setInputs(false);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @OnClick(R.id.btnSignUp)
    @Override
    public void handleSignUp() {
        loginPresenter.registerNewUser(txtEmail.getText().toString(), txtPassword.getText().toString());
    }

    @Override
    public void handleSignIn() {
        loginPresenter.validateLogin(txtEmail.getText().toString(), txtPassword.getText().toString());
    }

    @Override
    public void navigateToMainScreen() {
        startActivity(new Intent(this, ContactListActivity.class));
    }

    @Override
    public void loginError(String error) {

    }

    @Override
    public void newUserSuccess() {

    }

    @Override
    public void newUserError(String error) {

    }

    private void setInputs(boolean enabled){
        txtEmail.setEnabled(enabled);
        txtPassword.setEnabled(enabled);
        btnSignIn.setEnabled(enabled);
        btnSignUp.setEnabled(enabled);
    }
}
