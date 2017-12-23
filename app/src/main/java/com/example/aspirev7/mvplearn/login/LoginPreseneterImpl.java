package com.example.aspirev7.mvplearn.login;

/**
 * Created by WhoCares
 */

public class LoginPreseneterImpl implements LoginPresenter, LoginInteractor.onLoginFinishedListener {

    LoginView mLoginView;
    LoginInteractor mLoginInteractor;

    public LoginPreseneterImpl(LoginView loginView) {
        this.mLoginView = loginView;
        mLoginInteractor = new LoginInteractorImpl();
    }


    @Override
    public void validateCredentials(String userName, String password) {
        if (mLoginView != null) {
            mLoginView.showProgress();
            mLoginInteractor.login(userName, password, this);
        }
    }

    @Override
    public void onDestroy() {
        if (mLoginView != null) {
            mLoginView = null;
        }
    }

    @Override
    public void onUserNameError() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.setUserNameError();
        }
    }

    @Override
    public void onPasswordError() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.setPasswordError();
        }

    }

    @Override
    public void onSuccess() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.navigateToMain();

        }
    }

    @Override
    public void onFailure(String message) {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.showAlert(message);
        }
    }
}
