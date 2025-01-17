package com.digimat.showcase.Zonas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;

import java.util.ArrayList;
import java.util.List;

public class adapterServicios extends RecyclerView.Adapter<adapterServicios.ItemViewHolder> {

    private List<String> itemList;  // Lista de items a mostrar
    private Context context;
    // Constructor del Adapter
    public adapterServicios(List<String> itemList, Context context) {
        this.itemList = itemList;           //todo 16 rubros inspeccionar y revisar
        this.context = context;
    }

    // Este método crea el ViewHolder para cada item
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout para cada item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_servicios, parent, false);
        return new ItemViewHolder(view);
    }

    // Este método enlaza los datos con el ViewHolder
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        String item = itemList.get(position);

        // Asignamos los datos del item a las vistas correspondientes
        holder.nombreTextView.setText(item);
       // holder.descripcionTextView.setText(item.getDescripcion());
    }

    // Este método retorna la cantidad de items en la lista
    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // ViewHolder interno
    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView nombreTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);

            // Enlazamos las vistas del layout
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
        }
    }
}