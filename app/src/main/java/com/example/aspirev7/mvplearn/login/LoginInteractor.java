package com.example.aspirev7.mvplearn.login;

/**
 * Created by AspireV7 on 12/23/2017.
 */

public interface LoginInteractor {
    interface onLoginFinishedListener {
        void onUserNameError();

        void onPasswordError();

        void onSuccess();

        void onFailure(String message);

    }

    void login(String userName, String password, onLoginFinishedListener listener);
}
