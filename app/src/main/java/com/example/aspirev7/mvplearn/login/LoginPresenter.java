package com.example.aspirev7.mvplearn.login;

/**
 * Created by AspireV7 on 12/23/2017.
 */

public interface LoginPresenter {
    void validateCredentials(String userName, String password);
    void onDestroy();
}
