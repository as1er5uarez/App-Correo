package com.example.appcorreo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcorreo.R;

import java.util.ArrayList;
import com.example.appcorreo.models.Mail;

public class CorreoAdapter extends RecyclerView.Adapter<CorreoAdapter.RecyclerDataHolder> {
    ArrayList<Mail> listData;
    TextView txtName;
    TextView txtMsg;
    ImageView imgColor;
AdapterView.OnItemClickListener itemListener;
    public CorreoAdapter(ArrayList<Mail> listData, AdapterView.OnItemClickListener onItemClickListener) {
        this.listData = listData;
        this.itemListener = onItemClickListener;
    }
    @NonNull
    @Override
    public CorreoAdapter.RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_fragment, parent, false);
        return new CorreoAdapter.RecyclerDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CorreoAdapter.RecyclerDataHolder holder, int position) {
        Mail correo = listData.get(position);
        holder.assignData(correo, itemListener);
    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class RecyclerDataHolder extends RecyclerView.ViewHolder {
        public RecyclerDataHolder(@NonNull View itemView) {

            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtMsg = itemView.findViewById(R.id.txtMsg);
            imgColor = itemView.findViewById(R.id.imgPerfil);
        }

        public void assignData(Mail correo, AdapterView.OnItemClickListener itemListener) {
            txtName.setText(correo.getSenderName());
            txtMsg.setText(correo.getMessage());
            imgColor.setBackgroundColor(Integer.parseInt(correo.getColor()));
        }

    }


}
