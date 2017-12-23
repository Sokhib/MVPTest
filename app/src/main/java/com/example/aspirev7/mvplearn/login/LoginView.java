package com.example.aspirev7.mvplearn.login;

/**
 * Created by Let'sGoMVP
 */

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUserNameError();
    void setPasswordError();
    void navigateToMain();
    void showAlert(String message);

}
