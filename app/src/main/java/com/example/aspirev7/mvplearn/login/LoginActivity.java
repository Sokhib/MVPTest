package com.example.aspirev7.mvplearn.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.aspirev7.mvplearn.MainActivity;
import com.example.aspirev7.mvplearn.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button doneButton;
    private ProgressBar loadProgressBar;
    private LoginPresenter mLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
        mLoginPresenter = new LoginPreseneterImpl(this);


        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginPresenter.validateCredentials(userNameEditText.getText().toString().trim(),
                                                    passwordEditText.getText().toString().trim());
            }
        });

    }

    @Override
    public void showProgress() {
        loadProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        loadProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
        userNameEditText.setError("Username empty");
    }

    @Override
    public void setPasswordError() {
        passwordEditText.setError("Password empty");
    }

    @Override
    public void navigateToMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public void initialize(){
        userNameEditText = findViewById(R.id.editText_UserName);
        passwordEditText = findViewById(R.id.editText_Password);
        doneButton = findViewById(R.id.done_button);
        loadProgressBar = findViewById(R.id.progressBar);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.onDestroy();
    }
}
