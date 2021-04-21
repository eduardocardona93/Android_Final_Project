package com.example.android_final_project.products;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_final_project.LoginActivity;
import com.example.android_final_project.R;
import com.example.android_final_project.clients.Client;
import com.example.android_final_project.clients.ClientEditActivity;
import com.example.android_final_project.clients.ClientsListActivity;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {
    TextView productIdLbl, productNameLbl,productPriceLbl,productDescriptionLbl;
    ImageView productImg, imgReturnToProductList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        productIdLbl = findViewById(R.id.productIdLbl);
        productNameLbl = findViewById(R.id.productNameLbl);
        productPriceLbl = findViewById(R.id.productPriceLbl);
        productDescriptionLbl = findViewById(R.id.productDescriptionLbl);
        productImg = findViewById(R.id.productImg);
        imgReturnToProductList = findViewById(R.id.imgReturnToProductList);

        Product selectedProduct = ProductsListActivity.selectedProduct;

        productIdLbl.setText(String.valueOf(selectedProduct.getProdId()));
        productNameLbl.setText(String.valueOf(selectedProduct.getProdName()));
        productPriceLbl.setText("$ " + String.format("%.2f", selectedProduct.getProdPrice()));
        productDescriptionLbl.setText(String.valueOf(selectedProduct.getProdDescription()));

        int imgId=getResources().getIdentifier("product" + String.valueOf(selectedProduct.getProdId()),"mipmap",getPackageName());
        productImg.setImageResource(imgId);
        imgReturnToProductList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEdit = new Intent(getBaseContext(), ProductsListActivity.class);
                startActivity(intentEdit);
            }
        });
    }

}