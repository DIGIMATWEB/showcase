package com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios.dataServicesCatalog;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.view.bootomSheetServiciosCrud;

import java.util.List;

public class adapterServiciosCatalog extends RecyclerView.Adapter<adapterServiciosCatalog.ItemViewHolder> {

   // Lista de items a mostrar
    private Context context;
    private List<dataServicesCatalog> catalog;
    private bootomSheetServiciosCrud mview;
    // Constructor del Adapter
    public adapterServiciosCatalog(bootomSheetServiciosCrud mview, List<dataServicesCatalog> catalog, Context context) {
                //todo 16 rubros inspeccionar y revisar
        this.catalog=catalog;
        this.context = context;
        this.mview=mview;
    }

    // Este método crea el ViewHolder para cada item
    @Override
    public adapterServiciosCatalog.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout para cada item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_catalog, parent, false);
        return new adapterServiciosCatalog.ItemViewHolder(view);
    }

    // Este método enlaza los datos con el ViewHolder
    @Override
    public void onBindViewHolder(adapterServiciosCatalog.ItemViewHolder holder, int position) {
        holder.nombreTextView.setText(catalog.get(position).getNameService());
        holder.addService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    mview.addServiceDialog(1,"Tlayacapan",catalog.get(position).getIdService(),catalog.get(position).getNameService());
            }
        });
    }

    // Este método retorna la cantidad de items en la lista
    @Override
    public int getItemCount() {
        return catalog.size();
    }

    public void setFilter(List<String> filterList) {

        notifyDataSetChanged();
    }

    // ViewHolder interno
    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView nombreTextView;
        ImageView addService;

        public ItemViewHolder(View itemView) {
            super(itemView);

            // Enlazamos las vistas del layout
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            addService= itemView.findViewById(R.id. addService);
        }
    }
}