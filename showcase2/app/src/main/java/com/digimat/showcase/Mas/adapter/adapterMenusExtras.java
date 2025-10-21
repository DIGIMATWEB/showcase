package com.digimat.showcase.Mas.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;

public class adapterMenusExtras extends RecyclerView.Adapter<adapterMenusExtras.ViewHolder> {

    private Context context;


    public adapterMenusExtras(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public adapterMenusExtras.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_moremenus, parent, false);
        return new adapterMenusExtras.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterMenusExtras.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        // Crear las listas dentro del método para que se genere una nueva para cada vista

    }

    @Override
    public int getItemCount() {
        return 6;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}