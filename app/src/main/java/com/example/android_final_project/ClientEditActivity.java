package com.example.android_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class ClientEditActivity extends AppCompatActivity {
    EditText clientIdFld, clientNameFld, clientEmailFld, clientPhoneFld,clientCompanyCodeFld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_edit);
        clientIdFld = findViewById(R.id.clientIdFld);
        clientNameFld = findViewById(R.id.clientNameFld);
        clientEmailFld = findViewById(R.id.clientEmailFld);
        clientPhoneFld = findViewById(R.id.clientPhoneFld);
        clientCompanyCodeFld = findViewById(R.id.clientCompanyCodeFld);
    }
}