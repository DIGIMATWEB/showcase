package com.digimat.showcase.Alerts.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;

public class adapterAlertList extends RecyclerView.Adapter<adapterAlertList.ViewHolder> {

    private Context context;

    public adapterAlertList(Context context) {
        //this.puenteFechas = puenteFechas;
        this.context = context;
    }

    @NonNull
    @Override
    public adapterAlertList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alerts, parent, false);
        return new adapterAlertList.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterAlertList.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        // Crear las listas dentro del método para que se genere una nueva para cada vista
    }

    @Override
    public int getItemCount() {
        return 18;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}