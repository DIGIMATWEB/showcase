package com.digimat.showcase.Zonas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;

public class adapterCrudZones extends RecyclerView.Adapter<adapterCrudZones.ItemViewHolder> {
    private Context context;
    public adapterCrudZones(Context context) {
        this.context = context;
    }

    // Este método crea el ViewHolder para cada item
    @Override
    public adapterCrudZones.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout para cada item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dots, parent, false);
        return new adapterCrudZones.ItemViewHolder(view);
    }

    // Este método enlaza los datos con el ViewHolder
    @Override
    public void onBindViewHolder(adapterCrudZones.ItemViewHolder holder, int position) {
    }
    // Este método retorna la cantidad de items en la lista
    @Override
    public int getItemCount() {
        return 2;
    }
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
