package com.example.android_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.android_final_project.clients.Client;
import com.example.android_final_project.products.Product;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {
    EditText userNameFld, userFullnameFld, userPhoneFld, userEmailFld, userPasswordFld, userRetypePassFld;
    Button registerUserButton;
    ImageView imgBack;
    ConstraintLayout layout1;


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
        imgBack = findViewById(R.id.imgBack);
        layout1 = findViewById(R.id.layout1);

        userNameFld.setText("");
        userFullnameFld.setText("");
        userPhoneFld.setText("");
        userEmailFld.setText("");
        userPasswordFld.setText("");
        userRetypePassFld.setText("");

        imgBack.setOnClickListener(v -> finish());

        registerUserButton.setOnClickListener(v -> {

            if (userNameFld.getText().toString().isEmpty()) {
                Snackbar.make(layout1, "The username field is empty", Snackbar.LENGTH_SHORT).show();
            } else if (userFullnameFld.getText().toString().isEmpty()) {
                Snackbar.make(layout1, "The full name field is empty", Snackbar.LENGTH_SHORT).show();
            } else if (userPhoneFld.getText().toString().isEmpty()) {
                Snackbar.make(layout1, "The phone field is empty", Snackbar.LENGTH_SHORT).show();
            } else if (userEmailFld.getText().toString().isEmpty()) {
                Snackbar.make(layout1, "The email field is empty", Snackbar.LENGTH_SHORT).show();
            } else if (userPasswordFld.getText().toString().isEmpty()) {
                Snackbar.make(layout1, "The password field is empty", Snackbar.LENGTH_SHORT).show();
            } else if (userRetypePassFld.getText().toString().isEmpty()) {
                Snackbar.make(layout1, "The re-type password field is empty", Snackbar.LENGTH_SHORT).show();
            } else if (!userPasswordFld.getText().toString().equalsIgnoreCase(userRetypePassFld.getText().toString())) {
                Snackbar.make(layout1, "The passwords does not match", Snackbar.LENGTH_SHORT).show();
            } else {
                Salesperson newUser = new Salesperson(
                        userFullnameFld.getText().toString(),
                        userNameFld.getText().toString(),
                        userPasswordFld.getText().toString(),
                        userPhoneFld.getText().toString(),
                        userEmailFld.getText().toString()
                );

                LoginActivity.userList.add(newUser);

                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}