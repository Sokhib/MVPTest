package com.example.aspirev7.mvplearn.login;

import android.os.Handler;
import android.text.TextUtils;



/**
 * Created by Noone
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(String userName, String password,final onLoginFinishedListener listener) {
            if(TextUtils.isEmpty(userName))
                listener.onUserNameError();
            else if (TextUtils.isEmpty(password))
                listener.onPasswordError();
            else if(userName.equals("Soh1b") && password.equals("Said")){
                //delay 2 seconds to see progressBar
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listener.onSuccess();
                    }
                }, 2000);
            }

            else listener.onFailure("Invalid credentials");

    }
}
