package com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios.dataServicesCatalog;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.view.bootomSheetServiciosCrud;

import java.util.ArrayList;
import java.util.List;

public class adapterServiciosCrud extends RecyclerView.Adapter<adapterServiciosCrud.ItemViewHolder> {

    private List<dataServicesCatalog> catalog;  // Lista de items a mostrar
    private Context context;
    private bootomSheetServiciosCrud mview;
    // Constructor del Adapter
    public adapterServiciosCrud(bootomSheetServiciosCrud mview,List<dataServicesCatalog> catalog, Context context) {
        this.mview=mview;
        this.catalog = catalog;           //todo 16 rubros inspeccionar y revisar
        this.context = context;
    }

    // Este método crea el ViewHolder para cada item
    @Override
    public adapterServiciosCrud.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout para cada item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal_rv, parent, false);
        return new adapterServiciosCrud.ItemViewHolder(view);
    }

    // Este método enlaza los datos con el ViewHolder
    @Override
    public void onBindViewHolder(adapterServiciosCrud.ItemViewHolder holder, int position) {
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
        this.catalog = new ArrayList<>();
        this.catalog.addAll(filterList);
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