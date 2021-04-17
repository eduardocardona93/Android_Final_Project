package com.example.android_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_final_project.clients.ClientsListActivity;
import com.example.android_final_project.orders.OrdersListActivity;
import com.example.android_final_project.products.ProductsListActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtOrders, txtProducts, txtClients, txtLoggedInUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txtClients = findViewById(R.id.txtClients);
        txtOrders = findViewById(R.id.txtOrders);
        txtProducts = findViewById(R.id.txtProducts);
        txtLoggedInUser = findViewById(R.id.loggedAsUserNameLabel);

        txtLoggedInUser.setText(LoginActivity.loggedUser.getSpFullname());

        txtClients.setOnClickListener(this);
        txtProducts.setOnClickListener(this);
        txtOrders.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.txtClients) {
            startActivity(new Intent(HomeActivity.this, ClientsListActivity.class));
        } else if (v.getId() == R.id.txtOrders) {
            startActivity(new Intent(HomeActivity.this, OrdersListActivity.class));
        } else if (v.getId() == R.id.txtProducts) {
            startActivity(new Intent(HomeActivity.this, ProductsListActivity.class));
        }
    }
}