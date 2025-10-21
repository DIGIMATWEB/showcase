package com.digimat.showcase.Mas.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;

public class adapterInfo extends RecyclerView.Adapter<adapterInfo.ViewHolder> {

    private Context context;


    public adapterInfo(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public adapterInfo.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_moremenus, parent, false);
        return new adapterInfo.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterInfo.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        // Crear las listas dentro del método para que se genere una nueva para cada vista

    }

    @Override
    public int getItemCount() {
        return 2;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}