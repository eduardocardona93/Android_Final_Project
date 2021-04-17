package com.example.android_final_project.products;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.android_final_project.R;

public class ProductsListActivity extends AppCompatActivity {
    public static Product selectedProduct ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);
    }
}