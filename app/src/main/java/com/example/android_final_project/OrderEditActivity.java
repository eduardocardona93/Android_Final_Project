package com.example.android_final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class OrderEditActivity extends AppCompatActivity {
    TextView orderIdLbl, totalLbl;
    Spinner clientSp, paperTypeSp, bgColorSp, fontColorSp,fontTypeSp;
    EditText widthFld, heightFld, quantityFld;
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
    }
}