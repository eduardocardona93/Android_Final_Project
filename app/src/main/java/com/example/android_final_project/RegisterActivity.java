package com.example.android_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText userNameFld, userFullnameFld, userPhoneFld, userEmailFld, userPasswordFld,userRetypePassFld;
    Button registerUserButton;
    ImageView imgBack;
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
        imgBack=findViewById(R.id.imgBack);

        imgBack.setOnClickListener(this);
        registerUserButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgBack:{
                finish();
                break;
            }
            case R.id.registerUserButton:{
                break;
            }
        }
    }
}