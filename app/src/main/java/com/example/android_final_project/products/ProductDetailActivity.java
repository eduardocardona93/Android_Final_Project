package com.example.android_final_project.products;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_final_project.R;

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

        Product selectedProduct = ProductsListActivity.selectedProduct;

        productIdLbl.setText(String.valueOf(selectedProduct.getProdId()));
        productNameLbl.setText(String.valueOf(selectedProduct.getProdName()));
        productPriceLbl.setText("$ " + String.format("%.2f", selectedProduct.getProdPrice()));
        productDescriptionLbl.setText(String.valueOf(selectedProduct.getProdDescription()));

        int imgId=getResources().getIdentifier("product" + String.valueOf(selectedProduct.getProdId()),"mipmap",getPackageName());
        productImg.setImageResource(imgId);

    }
}