package com.example.android_final_project.orders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android_final_project.LoginActivity;
import com.example.android_final_project.clients.ClientsListActivity;
import com.example.android_final_project.products.Product;
import com.example.android_final_project.R;
import com.example.android_final_project.clients.Client;

import java.util.ArrayList;

public class OrderEditActivity extends AppCompatActivity {
    TextView orderIdLbl, totalLbl, orderEditTitleLbl;
    Spinner clientSp, paperTypeSp, bgColorSp, fontColorSp,fontTypeSp;
    EditText widthFld, heightFld, quantityFld;
    ImageView imgReturnToOrderList;
    Button saveOrderBtn;
    ConstraintLayout layoutEditOrder;
    public static ArrayList<Client> clientsList = new ArrayList<>();
    public static ArrayList<Product> producstList = new ArrayList<>();
    ArrayList<String> arrClients = new ArrayList<>();
    ArrayList<String> arrProducts = new ArrayList<>();
    String colors[] = { "Red",
            "White",
            "Cyan",
            "Silver",
            "Blue",
            "Gray",
            "DarkBlue",
            "Black",
            "LightBlue",
            "Orange",
            "Purple",
            "Brown",
            "Yellow",
            "Maroon",
            "Lime",
            "Green",
            "Magenta",
            "Olive"};

    String fonts[] = {
            "Helvetica",
            "Baskerville",
            "Times",
            "Akzidenz Grotesk",
            "Gotham",
            "Bodoni",
            "Didot",
            "Futura",
            "Gill Sans",
            "Frutiger",
            "Bembo",
            "Rockwell",
            "Franklin Gothic",
            "Sabon",
            "Georgia",
            "Garamond",
            "News Gothic",
            "Myriad",
            "Mrs Eaves",
            "Minion"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_edit);

        orderIdLbl = findViewById(R.id.orderIdLbl);
        totalLbl = findViewById(R.id.totalLbl);
        clientSp = findViewById(R.id.clientSp);
        paperTypeSp = findViewById(R.id.paperTypeSp);
        bgColorSp = findViewById(R.id.bgColorSp);
        fontColorSp = findViewById(R.id.fontColorSp);
        fontTypeSp = findViewById(R.id.fontTypeSp);
        widthFld = findViewById(R.id.widthFld);
        heightFld = findViewById(R.id.heightFld);
        quantityFld = findViewById(R.id.quantityFld);
        orderEditTitleLbl = findViewById(R.id.orderEditTitleLbl);
        saveOrderBtn = findViewById(R.id.saveOrderBtn);
        layoutEditOrder = findViewById(R.id.layoutEditOrder);
        imgReturnToOrderList =  findViewById(R.id.imgReturnToOrderList);

        clientsList = LoginActivity.clientsList;
        producstList = LoginActivity.producstList;
        clientsNames();
        productsNames();

        ArrayAdapter aaClients = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrClients);
        clientSp.setAdapter(aaClients);

        ArrayAdapter aaProducts = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrProducts);
        paperTypeSp.setAdapter(aaProducts);

        ArrayAdapter aaColor = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, colors);
        bgColorSp.setAdapter(aaColor);
        fontColorSp.setAdapter(aaColor);

        ArrayAdapter aaFont = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, fonts);
        fontTypeSp.setAdapter(aaFont);


        orderEditTitleLbl.setText("Create Order");
        if(OrdersListActivity.selectedOrder != null){
            orderEditTitleLbl.setText("Edit Order");
            orderIdLbl.setText(String.valueOf(OrdersListActivity.selectedOrder.getOrderId()));
            widthFld.setText(String.valueOf(OrdersListActivity.selectedOrder.getOrderWidth()));
            heightFld.setText(String.valueOf(OrdersListActivity.selectedOrder.getOrderHeight()));
            quantityFld.setText(String.valueOf(OrdersListActivity.selectedOrder.getOrderQuantity()));
        }else{

        }

        imgReturnToOrderList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getBaseContext(), OrdersListActivity.class);
                startActivity(intent);
            }
        });

        saveOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    public void clientsNames(){
        for (Client cli: clientsList) {
            arrClients.add(cli.getClientFullName() + " (" + cli.getClientIdentification() + ")");
        }

    }
    public void productsNames(){
        for (Product prod: producstList) {
            arrProducts.add(prod.getProdId() + " - " + prod.getProdName()  );
        }

    }

}