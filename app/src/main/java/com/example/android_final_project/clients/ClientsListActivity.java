package com.example.android_final_project.clients;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_final_project.LoginActivity;
import com.example.android_final_project.R;

import java.util.ArrayList;
import java.util.List;

public class ClientsListActivity extends AppCompatActivity {
    public static Client selectedClient;
    RecyclerView rcClients;
    // private List<Client> clientsListing = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients_list);
        rcClients = findViewById(R.id.rcClients);


        rcClients.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcClients.setAdapter(new ClientsAdapter(this, LoginActivity.clientsList));

        findViewById(R.id.imgAddClient).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Open Add Client activity
                //startActivity(new Intent(ClientsListActivity.this,Create));
            }
        });
    }

    class ClientsAdapter extends
            RecyclerView.Adapter<ClientsAdapter.ClientViewHolder> {

        private Activity activity;
        private List<Client> clientsListing = new ArrayList<>();


        ClientsAdapter(Activity activity, List<Client> clientsListing) {
            this.activity = activity;
            this.clientsListing = clientsListing;

        }

        @NonNull
        @Override
        public ClientsAdapter.ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_client_list, parent, false);

            return new ClientsAdapter.ClientViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ClientsAdapter.ClientViewHolder holder, int position) {
            holder.txtClientName.setText(clientsListing.get(position).getClientFullName());
            holder.txtClientPhoneNumber.setText(clientsListing.get(position).getClientPhoneNumber());
            holder.txtClientEmail.setText(clientsListing.get(position).getClientEmail());
            holder.listRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("Client Name ", clientsListing.get(position).getClientFullName());
                }
            });
            holder.txtEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("Client Name ", clientsListing.get(position).getClientFullName());
                }
            });
            holder.txtDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("Client Name ", clientsListing.get(position).getClientFullName());
                }
            });

        }

        @Override
        public int getItemCount() {
            return clientsListing.size();
        }

        class ClientViewHolder extends RecyclerView.ViewHolder {

            TextView txtClientName, txtClientPhoneNumber, txtClientEmail, txtEdit, txtDelete;
            ConstraintLayout listRow;


            public ClientViewHolder(@NonNull View itemView) {
                super(itemView);
                txtClientName = itemView.findViewById(R.id.txtClientName);
                txtClientEmail = itemView.findViewById(R.id.txtClientEmail);
                txtClientPhoneNumber = itemView.findViewById(R.id.txtClientPhoneNumber);
                listRow = itemView.findViewById(R.id.listRow);
                txtEdit = itemView.findViewById(R.id.txtEdit);
                txtDelete = itemView.findViewById(R.id.txtDelete);
            }
        }

    }
}