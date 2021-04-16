package com.example.android_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText loginUserFld, logInPasswordField;
    Button loginBtn;
    TextView registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginUserFld = findViewById(R.id.loginUserFld);
        logInPasswordField = findViewById(R.id.logInPasswordField);
        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);

        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginBtn :{
                startActivity(new Intent(this,HomeActivity.class));
                break;
            }
            case R.id.registerBtn : {
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}