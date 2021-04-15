package com.example.android_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {
    TextView productIdLbl, productNameLbl,productPriceLbl,productDescriptionLbl;
    ImageView productImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        productIdLbl = findViewById(R.id.productIdLbl);
        productNameLbl = findViewById(R.id.productNameLbl);
        productPriceLbl = findViewById(R.id.productPriceLbl);
        productDescriptionLbl = findViewById(R.id.productDescriptionLbl);
        productImg = findViewById(R.id.productImg);
    }
}