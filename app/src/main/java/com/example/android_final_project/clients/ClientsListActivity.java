package com.example.android_final_project.clients;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.android_final_project.LoginActivity;
import com.example.android_final_project.R;

import java.util.ArrayList;
import java.util.List;

public class ClientsListActivity extends AppCompatActivity {
    public static Client selectedClient;
    RecyclerView rcClients;
   // private List<Client> clientsListing = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients_list);
        rcClients=findViewById(R.id.rcClients);


        rcClients.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rcClients.setAdapter(new ClientsAdapter(this, LoginActivity.clientsList));
    }
}