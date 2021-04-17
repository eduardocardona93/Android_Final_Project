package com.example.android_final_project.clients;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_final_project.R;

import java.util.ArrayList;
import java.util.List;

;

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
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_client_list, parent, false);
        return new ClientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
            holder.txtClientName.setText(clientsListing.get(position).getClientFullName());
            holder.txtClientPhoneNumber.setText(clientsListing.get(position).getClientPhoneNumber());
            holder.txtClientEmail.setText(clientsListing.get(position).getClientEmail());
    }

    @Override
    public int getItemCount() {
        return clientsListing.size();
    }

    class ClientViewHolder extends RecyclerView.ViewHolder {

        TextView txtClientName,txtClientPhoneNumber,txtClientEmail;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
            txtClientName=itemView.findViewById(R.id.txtClientName);
            txtClientEmail=itemView.findViewById(R.id.txtClientEmail);
            txtClientPhoneNumber=itemView.findViewById(R.id.txtClientPhoneNumber);
        }
    }

}