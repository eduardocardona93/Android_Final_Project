package com.example.android_final_project.orders;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.android_final_project.R;

public class OrdersListActivity extends AppCompatActivity {
    public static Order selectedOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_list);
    }
}