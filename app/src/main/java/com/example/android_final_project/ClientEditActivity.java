package com.example.android_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.MailTo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ClientEditActivity extends AppCompatActivity {
    EditText clientIdFld, clientNameFld, clientEmailFld, clientPhoneFld,clientCompanyCodeFld;
    TextView clientEditTitleLbl;
    Button saveClientBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_edit);
        clientIdFld = findViewById(R.id.clientIdFld);
        clientNameFld = findViewById(R.id.clientNameFld);
        clientEmailFld = findViewById(R.id.clientEmailFld);
        clientPhoneFld = findViewById(R.id.clientPhoneFld);
        clientCompanyCodeFld = findViewById(R.id.clientCompanyCodeFld);
        clientEditTitleLbl = findViewById(R.id.clientEditTitleLbl);
        saveClientBtn = findViewById(R.id.saveClientBtn);


        clientEditTitleLbl.setText("Add Client");
        if(ClientsListActivity.selectedClient != null){
            clientEditTitleLbl.setText("Edit Client");
            clientIdFld.setText(String.valueOf(ClientsListActivity.selectedClient.getClientIdentification()));
            clientNameFld.setText(String.valueOf(ClientsListActivity.selectedClient.getClientFullName()));
            clientCompanyCodeFld.setText(String.valueOf(ClientsListActivity.selectedClient.getClientCompanyCode()));
            clientEmailFld.setText(String.valueOf(ClientsListActivity.selectedClient.getClientEmail()));
            clientPhoneFld.setText(String.valueOf(ClientsListActivity.selectedClient.getClientPhoneNumber()));
        }

        saveClientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clientIdFld.getText().toString().isEmpty()) {
                    Toast.makeText(getBaseContext(), "The identification field is empty", Toast.LENGTH_SHORT).show();
                }else if (clientNameFld.getText().toString().isEmpty()) {
                    Toast.makeText(getBaseContext(), "The full name field is empty", Toast.LENGTH_SHORT).show();
                }else if (clientCompanyCodeFld.getText().toString().isEmpty()) {
                    Toast.makeText(getBaseContext(), "The company code field is empty", Toast.LENGTH_SHORT).show();
                }else if (clientEmailFld.getText().toString().isEmpty()) {
                    Toast.makeText(getBaseContext(), "The email field is empty", Toast.LENGTH_SHORT).show();
                }else if (clientPhoneFld.getText().toString().isEmpty()) {
                    Toast.makeText(getBaseContext(), "The phone field is empty", Toast.LENGTH_SHORT).show();
                }else{
                    if(ClientsListActivity.selectedClient != null){
                        LoginActivity.clientsList.add(new Client(
                                clientNameFld.getText().toString(),
                                clientIdFld.getText().toString(),
                                clientCompanyCodeFld.getText().toString(),
                                clientPhoneFld.getText().toString(),
                                clientEmailFld.getText().toString())
                        );

                        Toast.makeText(getBaseContext(), "Client Successfully created", Toast.LENGTH_SHORT).show();
                    }else{
                        ClientsListActivity.selectedClient.setClientIdentification(clientIdFld.getText().toString());
                        ClientsListActivity.selectedClient.setClientFullName(clientNameFld.getText().toString());
                        ClientsListActivity.selectedClient.setClientEmail(clientEmailFld.getText().toString());
                        ClientsListActivity.selectedClient.setClientCompanyCode(clientCompanyCodeFld.getText().toString());
                        ClientsListActivity.selectedClient.setClientPhoneNumber(clientPhoneFld.getText().toString());
                        Toast.makeText(getBaseContext(), "Client Successfully edited", Toast.LENGTH_SHORT).show();
                    }

                    Intent intent = new Intent( getBaseContext(), ClientsListActivity.class);
                    startActivity(intent);

                }
            }
        });
    }
}