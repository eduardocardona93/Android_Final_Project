package com.example.android_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText userNameFld, userFullnameFld, userPhoneFld, userEmailFld, userPasswordFld,userRetypePassFld;
    Button registerUserButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userNameFld = findViewById(R.id.userNameFld);
        userFullnameFld = findViewById(R.id.userFullnameFld);
        userPhoneFld = findViewById(R.id.userPhoneFld);
        userEmailFld = findViewById(R.id.userEmailFld);
        userPasswordFld = findViewById(R.id.userPasswordFld);
        userRetypePassFld = findViewById(R.id.userRetypePassFld);
        registerUserButton = findViewById(R.id.registerUserButton);

    }
}