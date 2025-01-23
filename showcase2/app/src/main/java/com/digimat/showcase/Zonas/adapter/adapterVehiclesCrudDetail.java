package com.digimat.showcase.Zonas.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;
import com.digimat.showcase.Zonas.view.Zonas;

public class adapterVehiclesCrudDetail extends RecyclerView.Adapter<adapterVehiclesCrudDetail.ItemViewHolder> {
    private Context context;
    private Zonas mview;
    public adapterVehiclesCrudDetail(Zonas mview, Context context, String path) {

    }
    // Este método crea el ViewHolder para cada item
    @Override
    public adapterVehiclesCrudDetail.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout para cada item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dots, parent, false);
        return new adapterVehiclesCrudDetail.ItemViewHolder(view);
    }

    // Este método enlaza los datos con el ViewHolder
    @Override
    public void onBindViewHolder(adapterVehiclesCrudDetail.ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {

    }

    // Este método retorna la cantidad de items en la lista
    @Override
    public int getItemCount() {
        return 5;
    }
    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}