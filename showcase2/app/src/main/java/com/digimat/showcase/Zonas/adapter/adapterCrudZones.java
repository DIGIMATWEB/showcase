package com.digimat.showcase.Zonas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;
import com.digimat.showcase.Zonas.Dialogs.model.dotZones;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class adapterCrudZones extends RecyclerView.Adapter<adapterCrudZones.ItemViewHolder> {
    private Context context;
    private List<dotZones> dotZoness=new ArrayList<>();
    public adapterCrudZones(List<dotZones> dotZoness, Context context) {
        this.dotZoness=dotZoness;
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
        holder.editTextLat.setText(dotZoness.get(position).getLatitud());
        holder.editTextLong.setText(dotZoness.get(position).getLongitud());
    }
    // Este método retorna la cantidad de items en la lista
    @Override
    public int getItemCount() {
        return dotZoness.size();
    }

    public void addDot(LatLng position) {
        dotZoness.add(new dotZones(String.valueOf(position.latitude),String.valueOf(position.longitude)));
        notifyDataSetChanged();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView editTextLong,editTextLat;
        public ItemViewHolder(View itemView) {
            super(itemView);
            editTextLong = itemView.findViewById(R.id.editTextLong);
            editTextLat= itemView.findViewById(R.id.editTextLat);
        }
    }
}
