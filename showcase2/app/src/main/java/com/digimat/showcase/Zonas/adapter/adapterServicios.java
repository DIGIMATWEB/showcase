package com.digimat.showcase.Zonas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;
import com.digimat.showcase.Zonas.Dialogs.Servicios.view.bootmSheetsServicios;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios.dataServicesCatalog;

import java.util.ArrayList;
import java.util.List;

public class adapterServicios extends RecyclerView.Adapter<adapterServicios.ItemViewHolder> {

    private List<dataServicesCatalog> itemList;  // Lista de items a mostrar
    private Context context;
    private List<dataServicesCatalog> catalog;
    private bootmSheetsServicios mview;
    // Constructor del Adapter

    public adapterServicios(bootmSheetsServicios mview,List<dataServicesCatalog> catalog, Context context) {
        this.mview = mview;
        this.catalog = catalog;           //todo 16 rubros inspeccionar y revisar
        this.context = context;
    }

    // Este método crea el ViewHolder para cada item
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout para cada item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal_rv, parent, false);
        return new ItemViewHolder(view);
    }

    // Este método enlaza los datos con el ViewHolder
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        dataServicesCatalog item = catalog.get(position);

        // Asignamos los datos del item a las vistas correspondientes
        holder.nombreTextView.setText(item.getNameService());
       // holder.descripcionTextView.setText(item.getDescripcion());
    }

    // Este método retorna la cantidad de items en la lista
    @Override
    public int getItemCount() {
        return catalog.size();
    }

    public void setFilter(List<dataServicesCatalog> filterList) {
        this.itemList = new ArrayList<>();
        this.itemList.addAll(filterList);
        notifyDataSetChanged();
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