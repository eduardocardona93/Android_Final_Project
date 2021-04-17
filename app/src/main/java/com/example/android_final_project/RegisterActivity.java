package com.example.android_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_final_project.clients.Client;
import com.example.android_final_project.products.Product;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {
    EditText userNameFld, userFullnameFld, userPhoneFld, userEmailFld, userPasswordFld, userRetypePassFld;
    Button registerUserButton;
    ImageView imgBack;
    public static ArrayList<Salesperson> userList = new ArrayList<>();
    public static ArrayList<Client> clientsList = new ArrayList<>();
    public static ArrayList<Product> producstList = new ArrayList<>();


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

        producstList = LoginActivity.producstList;
        clientsList = LoginActivity.clientsList;
        userList = LoginActivity.userList;

        imgBack.setOnClickListener(v -> finish());

        registerUserButton.setOnClickListener(v -> {

            if (userNameFld.getText().toString().isEmpty()) {
                Toast.makeText(getBaseContext(), "The username field is empty", Toast.LENGTH_SHORT).show();
            } else if (userFullnameFld.getText().toString().isEmpty()) {
                Toast.makeText(getBaseContext(), "The full name field is empty", Toast.LENGTH_SHORT).show();
            } else if (userPhoneFld.getText().toString().isEmpty()) {
                Toast.makeText(getBaseContext(), "The phone field is empty", Toast.LENGTH_SHORT).show();
            } else if (userEmailFld.getText().toString().isEmpty()) {
                Toast.makeText(getBaseContext(), "The email field is empty", Toast.LENGTH_SHORT).show();
            } else if (userPasswordFld.getText().toString().isEmpty()) {
                Toast.makeText(getBaseContext(), "The password field is empty", Toast.LENGTH_SHORT).show();
            } else if (userRetypePassFld.getText().toString().isEmpty()) {
                Toast.makeText(getBaseContext(), "The re-type password field is empty", Toast.LENGTH_SHORT).show();
            } else if (!userPasswordFld.getText().toString().equalsIgnoreCase(userRetypePassFld.getText().toString())) {
                Toast.makeText(getBaseContext(), "The passwords does not match", Toast.LENGTH_SHORT).show();
            } else {
                Salesperson newUser = new Salesperson(
                        userFullnameFld.getText().toString(),
                        userNameFld.getText().toString(),
                        userPasswordFld.getText().toString(),
                        userPhoneFld.getText().toString(),
                        userEmailFld.getText().toString()
                );

                userList.add(newUser);

                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}