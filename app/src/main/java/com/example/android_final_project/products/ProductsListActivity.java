package com.example.android_final_project.products;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_final_project.HomeActivity;
import com.example.android_final_project.LoginActivity;
import com.example.android_final_project.R;


import java.util.ArrayList;
import java.util.List;

public class ProductsListActivity extends AppCompatActivity {
    RecyclerView rcProducts;
    ImageView productListReturnHome;
    public static Product selectedProduct ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        rcProducts = findViewById(R.id.rcProducts);
        productListReturnHome = findViewById(R.id.productListReturnHome);


        rcProducts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcProducts.setAdapter(new ProductsListActivity.ProductsAdapter(this, LoginActivity.producstList));

        productListReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEdit = new Intent(getBaseContext(), HomeActivity.class);
                startActivity(intentEdit);
            }
        });
    }

    class ProductsAdapter extends
            RecyclerView.Adapter<ProductsListActivity.ProductsAdapter.ProductViewHolder> {

        private Activity activity;
        private List<Product> productsListing = new ArrayList<>();


        ProductsAdapter(Activity activity, List<Product> productsListing) {
            this.activity = activity;
            this.productsListing = productsListing;

        }

        @NonNull
        @Override
        public ProductsListActivity.ProductsAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_products, parent, false);

            return new  ProductsListActivity.ProductsAdapter.ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductsListActivity.ProductsAdapter.ProductViewHolder holder, int position) {
            holder.txtNameProduct.setText(productsListing.get(position).getProdName());
            int imgId=getResources().getIdentifier("product" + String.valueOf(productsListing.get(position).getProdId()),"mipmap",getPackageName());
            holder.imgProduct.setImageResource(imgId);;
            holder.productListRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedProduct = productsListing.get(position);
                    Intent intentEdit = new Intent(getBaseContext(), ProductDetailActivity.class);
                    startActivity(intentEdit);
                }
            });


        }

        @Override
        public int getItemCount() {
            return productsListing.size();
        }

        class ProductViewHolder extends RecyclerView.ViewHolder {

            TextView txtNameProduct;
            ImageView imgProduct;
            ConstraintLayout productListRow;


            public ProductViewHolder(@NonNull View itemView) {
                super(itemView);
                txtNameProduct = itemView.findViewById(R.id.txtNameProduct);
                imgProduct = itemView.findViewById(R.id.imgProduct);
                productListRow = itemView.findViewById(R.id.productListRow);

            }
        }

    }
}