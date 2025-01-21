package com.digimat.showcase.Zonas.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;
import com.digimat.showcase.Zonas.view.Zonas;

public class adapterVehicles extends RecyclerView.Adapter<adapterVehicles.ItemViewHolder> {
private Context context;
private Zonas mview;
// Constructor del Adapter
public adapterVehicles(Zonas mview, Context context) {
    this.mview=mview;
    this.context = context;
}
// Este método crea el ViewHolder para cada item
@Override
public adapterVehicles.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    // Inflamos el layout para cada item
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vehicle, parent, false);
    return new adapterVehicles.ItemViewHolder(view);
}

// Este método enlaza los datos con el ViewHolder
@Override
public void onBindViewHolder(adapterVehicles.ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {

}

// Este método retorna la cantidad de items en la lista
@Override
public int getItemCount() {
    return 5;
}

// ViewHolder interno
public static class ItemViewHolder extends RecyclerView.ViewHolder {
    private TextView textNameUsr;
    private ImageView location;

    public ItemViewHolder(View itemView) {
        super(itemView);
    }
}

}
