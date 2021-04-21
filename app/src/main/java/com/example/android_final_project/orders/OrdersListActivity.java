package com.example.android_final_project.orders;

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
import com.example.android_final_project.clients.Client;
import com.example.android_final_project.clients.ClientEditActivity;
import com.example.android_final_project.clients.ClientsListActivity;
import com.example.android_final_project.products.Product;

import java.util.ArrayList;
import java.util.List;

public class OrdersListActivity extends AppCompatActivity {
    public static Order selectedOrder;
    public static int selectedPosition = -1;
    RecyclerView rcOrders;
    ImageView orderListReturnHome;
    TextView addLbl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_list);
        rcOrders = findViewById(R.id.rcOrders);
        addLbl = findViewById(R.id.addLbl);

        orderListReturnHome = findViewById(R.id.orderListReturnHome);

        rcOrders.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcOrders.setAdapter(new OrdersListActivity.OrdersAdapter(this, LoginActivity.orderList));

        addLbl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition = -1;
                Intent intentEdit = new Intent(getBaseContext(), OrderEditActivity.class);
                startActivity(intentEdit);
            }
        });

        orderListReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEdit = new Intent(getBaseContext(), HomeActivity.class);
                startActivity(intentEdit);
            }
        });
    }

    class OrdersAdapter extends
            RecyclerView.Adapter<OrdersListActivity.OrdersAdapter.OrderViewHolder> {

        private Activity activity;
        private List<Order> orderList = new ArrayList<>();


        OrdersAdapter(Activity activity, List<Order> orderList) {
            this.activity = activity;
            this.orderList = orderList;

        }

        @NonNull
        @Override
        public OrdersListActivity.OrdersAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_orders, parent, false);

            return new OrdersListActivity.OrdersAdapter.OrderViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull OrdersListActivity.OrdersAdapter.OrderViewHolder holder, int position) {
            holder.orderId.setText(orderList.get(position).getOrderId());
            holder.orderClient.setText(orderList.get(position).getOrderClient());
            holder.orderProduct.setText(orderList.get(position).getOrderClient());
//            holder.listRow.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.e("Client Name ", clientsListing.get(position).getClientFullName());
//                }
//            });
            holder.editOrderBtnImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedOrder = orderList.get(position);
                    selectedPosition = position;
                    Intent intentEdit = new Intent(getBaseContext(), OrderEditActivity.class);
                    startActivity(intentEdit);
                }
            });

        }

        @Override
        public int getItemCount() {
            return orderList.size();
        }

        class OrderViewHolder extends RecyclerView.ViewHolder {

            TextView orderId, orderClient, orderProduct,editOrderBtnImg;
            ConstraintLayout productListRow;


            public OrderViewHolder(@NonNull View itemView) {
                super(itemView);
                orderId = itemView.findViewById(R.id.orderId);
                orderClient = itemView.findViewById(R.id.orderClient);
                orderProduct = itemView.findViewById(R.id.orderProduct);
                productListRow = itemView.findViewById(R.id.productListRow);
                editOrderBtnImg = itemView.findViewById(R.id.editOrderBtnImg);
            }
        }

    }
}