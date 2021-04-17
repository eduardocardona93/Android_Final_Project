package com.example.android_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    EditText loginUserFld, logInPasswordField;
    Button loginBtn, registerBtn;

    public static ArrayList<Salesperson> userList = new ArrayList<>();
    public static ArrayList<Client> clientsList = new ArrayList<>();
    public static ArrayList<Product> producstList = new ArrayList<>();

    public static Salesperson loggedUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginUserFld = findViewById(R.id.loginUserFld);
        logInPasswordField = findViewById(R.id.logInPasswordField);
        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getBaseContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginUserFld.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(), "The user field is empty", Toast.LENGTH_SHORT).show();
                }else if(logInPasswordField.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(), "The password field is empty", Toast.LENGTH_SHORT).show();
                }else{
                    for (Salesperson user: userList) {
                        if((user.getSpEmail().equalsIgnoreCase(loginUserFld.getText().toString()) || user.getSpUsername().equalsIgnoreCase(loginUserFld.getText().toString())) && user.getSpPassword().equals(logInPasswordField.getText().toString())){
                            loggedUser = user;
                            Intent intent = new Intent( getBaseContext(), HomeActivity.class);
                            startActivity(intent);
                        }
                    }
                    if (loggedUser == null){
                        Toast.makeText(getBaseContext(), "Invalid user/email or password", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getBaseContext(), "Welcome " + loggedUser.getSpFullname(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        fillProducts();
        fillUsers();
        fillClients();
    }
//
    public void fillUsers(){
        if(userList.size() == 0 ){
            userList.add(new Salesperson( "Eduardo Cardona",  "eduardoacm93",  "123456", "5555555","eduardoacm93@company.com"));
            userList.add(new Salesperson( "Ranjana",  "ranjana",  "778899", "3232323", "ranjana@company.com"));
            userList.add(new Salesperson( "Dina Johnson",  "dj",  "000111", "4545454",  "dj@company.com"));
        }

    }

    public void fillClients(){
        if(clientsList.size() == 0){
            clientsList.add(new Client( "111111" ,  "Rasagjna Ghandi" ,  "21554" ,  "913133337755" ,  "example1@company1.com" ));
            clientsList.add(new Client( "222222" ,  "Lino Hernandez" ,  "21553" ,  "915133436754" ,  "example2@company2.com" ));
        }
    }

    public void fillProducts(){
        if(producstList.size() == 0) {
            producstList.add(new Product(100, "Inkjet printer paper", 10.0, "this type of papper is designed for specific use with"));
            producstList.add(new Product(200, "Matte", 5.0, "particularly for those seeking a softer, smoother appearance that minimizes glare."));
            producstList.add(new Product(300, "Bright White", 5.0, "it is Multipurpose Office Paper is very suitable to be used in fast speeds and hassle-free printers and copiers"));
            producstList.add(new Product(400, "Glossy", 15.0, "It is a high quality resin coated photographic paper with a glossy finish."));
            producstList.add(new Product(500, "Paper Banner Printing", 30.0, "Paper prints are meant for indoor use only"));
            producstList.add(new Product(1100, "No Curl Vinyl Banners", 25.0, "non-curl banners have a non-curling edge, allowing them to lie flat without using hemming tapes"));
            producstList.add(new Product(1200, "Mesh Banners", 36.0, "They have little holes to allow some wind to go through the material which is used in windy environments"));
            producstList.add(new Product(1300, "Canvas Banners", 40.0, "A Canvas Banners are pritned using a digital print"));
            producstList.add(new Product(1400, "Polyester Fabric Banners", 35.0, "these banners are perfect for both indoor and outdoor settings, because it has features like non twist, waterproof and lightweight."));
            producstList.add(new Product(1500, "Vinyl Banner Printing", 25.0, "digitally printed on large format inkjet printers which are capable of printing a full color outdoor billboard on a single piece of material."));
        }
    }



}