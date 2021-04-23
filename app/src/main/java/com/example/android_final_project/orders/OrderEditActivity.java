package com.example.android_final_project.orders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_final_project.HomeActivity;
import com.example.android_final_project.LoginActivity;
import com.example.android_final_project.clients.ClientsListActivity;
import com.example.android_final_project.products.Product;
import com.example.android_final_project.R;
import com.example.android_final_project.clients.Client;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class OrderEditActivity extends AppCompatActivity {
    TextView orderIdLbl, totalLbl, orderEditTitleLbl;
    Spinner clientSp, paperTypeSp, bgColorSp, fontColorSp,fontTypeSp;
    EditText widthFld, heightFld, quantityFld;
    ImageView imgReturnToOrderList;
    Button saveOrderBtn;
    ConstraintLayout layoutEditOrder;


    String arrClients[];
    String arrProducts[];
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
    double sqftPrice = 0.0, totalPrice= 0.0;
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


        clientsNames();
        productsNames();

        ArrayAdapter aaClients = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrClients);
        clientSp.setAdapter(aaClients);

        ArrayAdapter aaProducts = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrProducts);
        paperTypeSp.setAdapter(aaProducts);

        paperTypeSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sqftPrice = LoginActivity.producstList.get(position).getProdPrice();
                calculatePrice();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                if (OrdersListActivity.selectedPosition == -1) {
                    sqftPrice = LoginActivity.producstList.get(0).getProdPrice();
                    calculatePrice();
                }

            }
        });

        ArrayAdapter aaColor = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, colors);
        bgColorSp.setAdapter(aaColor);
        fontColorSp.setAdapter(aaColor);

        ArrayAdapter aaFont = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, fonts);
        fontTypeSp.setAdapter(aaFont);

        widthFld.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                calculatePrice();
            }
        });
        heightFld.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                calculatePrice();
            }
        });
        quantityFld.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                calculatePrice();
            }
        });
        orderEditTitleLbl.setText("Create Order");
        if (OrdersListActivity.selectedPosition > -1) {
            orderIdLbl.setText(String.valueOf(OrdersListActivity.selectedOrder.getOrderId()));
            orderEditTitleLbl.setText("Edit Order");
            sqftPrice = OrdersListActivity.selectedOrder.getOrderPaperPrice();
            clientSp.setSelection(searchIndexByName(OrdersListActivity.selectedOrder.getOrderClient() , arrClients));
            paperTypeSp.setSelection(searchIndexByName(String.valueOf(OrdersListActivity.selectedOrder.getOrderProduct()) , arrProducts));
            fontColorSp.setSelection(searchIndexByName(OrdersListActivity.selectedOrder.getOrderFontColor() , colors));
            bgColorSp.setSelection(searchIndexByName(OrdersListActivity.selectedOrder.getOrderBgColor(), colors));
            fontTypeSp.setSelection(searchIndexByName(OrdersListActivity.selectedOrder.getOrderFontStyle() , fonts));
            widthFld.setText(String.valueOf(OrdersListActivity.selectedOrder.getOrderWidth()));
            heightFld.setText(String.valueOf(OrdersListActivity.selectedOrder.getOrderHeight()));
            quantityFld.setText(String.valueOf(OrdersListActivity.selectedOrder.getOrderQuantity()));
        }else{
            orderIdLbl.setText(String.format("%03d", LoginActivity.orderList.size() + 1));
            orderEditTitleLbl.setText("Create Order");
            sqftPrice = LoginActivity.producstList.get(0).getProdPrice();
            clientSp.setSelection(0);
            paperTypeSp.setSelection(0);
            fontColorSp.setSelection(0);
            bgColorSp.setSelection(0);
            fontTypeSp.setSelection(0);
            widthFld.setText("12");
            heightFld.setText("1");
            quantityFld.setText("1");
        }
        calculatePrice();
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
                if(widthFld.getText().toString().isEmpty()){
                    Snackbar.make(layoutEditOrder, "The width field is empty", Snackbar.LENGTH_SHORT).show();
                }else if(heightFld.getText().toString().isEmpty()){
                    Snackbar.make(layoutEditOrder, "The height field is empty", Snackbar.LENGTH_SHORT).show();
                }else if(quantityFld.getText().toString().isEmpty()){
                    Snackbar.make(layoutEditOrder, "The quantity field is empty", Snackbar.LENGTH_SHORT).show();
                } else {
                        if (OrdersListActivity.selectedPosition == -1) {
                            LoginActivity.orderList.add(new Order(
                                    orderIdLbl.getText().toString(),
                                    arrClients[clientSp.getSelectedItemPosition()],
                                    arrProducts[paperTypeSp.getSelectedItemPosition()],
                                    colors[bgColorSp.getSelectedItemPosition()],
                                    colors[fontColorSp.getSelectedItemPosition()],
                                    fonts[fontTypeSp.getSelectedItemPosition()],
                                    Integer.parseInt(heightFld.getText().toString()),
                                    Integer.parseInt(widthFld.getText().toString()),
                                    Integer.parseInt(quantityFld.getText().toString()),
                                    totalPrice,
                                    sqftPrice
                            ));
                            Toast.makeText(getBaseContext(), "Order Successfully Created", Toast.LENGTH_SHORT).show();
                        } else {
                            LoginActivity.orderList.get(OrdersListActivity.selectedPosition).setOrderClient(arrClients[clientSp.getSelectedItemPosition()]);
                            LoginActivity.orderList.get(OrdersListActivity.selectedPosition).setOrderProduct(arrProducts[paperTypeSp.getSelectedItemPosition()]);
                            LoginActivity.orderList.get(OrdersListActivity.selectedPosition).setOrderBgColor(colors[bgColorSp.getSelectedItemPosition()]);
                            LoginActivity.orderList.get(OrdersListActivity.selectedPosition).setOrderFontColor(colors[fontColorSp.getSelectedItemPosition()]);
                            LoginActivity.orderList.get(OrdersListActivity.selectedPosition).setOrderFontStyle(fonts[fontTypeSp.getSelectedItemPosition()]);
                            LoginActivity.orderList.get(OrdersListActivity.selectedPosition).setOrderHeight(Integer.parseInt(heightFld.getText().toString()));
                            LoginActivity.orderList.get(OrdersListActivity.selectedPosition).setOrderWidth(Integer.parseInt(widthFld.getText().toString()));
                            LoginActivity.orderList.get(OrdersListActivity.selectedPosition).setOrderQuantity(Integer.parseInt(quantityFld.getText().toString()));
                            LoginActivity.orderList.get(OrdersListActivity.selectedPosition).setOrderAmount(totalPrice);
                            LoginActivity.orderList.get(OrdersListActivity.selectedPosition).setOrderPaperPrice(sqftPrice);
                            Toast.makeText(getBaseContext(), "Order Successfully Edited", Toast.LENGTH_SHORT).show();
                        }

                        finish();
                    }
                }
        });

    }
    public void clientsNames(){
        arrClients = new String[LoginActivity.clientsList.size()];
        for (int i = 0; i < LoginActivity.clientsList.size(); i++){
            arrClients[i] = LoginActivity.clientsList.get(i).getClientFullName() + " (" + LoginActivity.clientsList.get(i).getClientIdentification() + ")";
        }

    }
    public void productsNames(){
        arrProducts = new String[LoginActivity.producstList.size()];
        for (int i = 0; i < LoginActivity.producstList.size(); i++){
            arrProducts[i] = LoginActivity.producstList.get(i).getProdId() + " (" + LoginActivity.producstList.get(i).getProdName() + ")";
        }
    }

    public int searchIndexByName(String name, String[] namesList){
        for (int i = 0; i < namesList.length; i++){
            if(name.equals(namesList[i])){
                return i;
            }
        }
        return -1;
    }

    public void calculatePrice(){
        if(!widthFld.getText().toString().isEmpty() && !heightFld.getText().toString().isEmpty() && !quantityFld.getText().toString().isEmpty()){

            totalPrice = sqftPrice * Double.parseDouble(widthFld.getText().toString())/12.0 * Double.parseDouble(heightFld.getText().toString()) * Double.parseDouble(quantityFld.getText().toString());
            totalLbl.setText("$ " + String.format("%.2f" , totalPrice));
        }
    }

}