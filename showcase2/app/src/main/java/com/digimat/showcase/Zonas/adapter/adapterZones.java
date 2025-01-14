package com.digimat.showcase.Zonas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;
import com.digimat.showcase.Zonas.Dialogs.model.dataGetAllZones;

import java.util.List;

public class adapterZones extends RecyclerView.Adapter<adapterZones.ItemViewHolder> {
    private Context context;
    private List<dataGetAllZones> data;
    public adapterZones(List<dataGetAllZones> data, Context context) {
        this.data=data;
        this.context = context;
    }

    // Este método crea el ViewHolder para cada item
    @Override
    public adapterZones.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout para cada item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_zones, parent, false);
        return new adapterZones.ItemViewHolder(view);
    }

    // Este método enlaza los datos con el ViewHolder
    @Override
    public void onBindViewHolder(adapterZones.ItemViewHolder holder, int position) {
        holder.nameZone.setText(data.get(position).getZoneName());
    }
    // Este método retorna la cantidad de items en la lista
    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView nameZone;
        public ItemViewHolder(View itemView) {
            super(itemView);
            nameZone=itemView.findViewById(R.id.nameZone);
        }
    }
}
