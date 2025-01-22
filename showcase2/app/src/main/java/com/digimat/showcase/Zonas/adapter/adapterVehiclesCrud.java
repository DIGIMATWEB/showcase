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
import com.digimat.showcase.Zonas.model.getVehicles.dataVehicles;
import com.digimat.showcase.Zonas.view.Zonas;

import java.util.ArrayList;
import java.util.List;

public class adapterVehiclesCrud extends RecyclerView.Adapter<adapterVehiclesCrud.ItemViewHolder> {
    private Context context;
    private Zonas mview;
    private List<dataVehicles> vehicles;
    private Boolean isfistTime;
    // Constructor del Adapter
    public adapterVehiclesCrud(Zonas mview, Context context, List<dataVehicles> vehicles, Boolean isfistTime) {
        this.mview=mview;
        this.context = context;
        this.vehicles=vehicles;
        this.isfistTime=isfistTime;
        if(this.isfistTime){
            if(vehicles!=null) {
                List<dataVehicles> bvehicles = new ArrayList<>();
                for (dataVehicles vehiclesmain : vehicles) {
                    if (!vehiclesmain.getIsBot().equals("1")) {
                        bvehicles.add(vehiclesmain);
                    }
                }
                this.vehicles = bvehicles;
                this.isfistTime = false;
            }
        }

    }
    // Este método crea el ViewHolder para cada item
    @Override
    public adapterVehiclesCrud.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout para cada item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vehicle, parent, false);
        return new adapterVehiclesCrud.ItemViewHolder(view);
    }

    // Este método enlaza los datos con el ViewHolder
    @Override
    public void onBindViewHolder(adapterVehiclesCrud.ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {

    }

    // Este método retorna la cantidad de items en la lista
    @Override
    public int getItemCount() {
        return vehicles.size();
    }

    public void filterByBots(List<dataVehicles> mvehicles) {
        vehicles=new ArrayList<>();
        // Log.e("SwitchVehicles", "Apagado"+" vehicles: " +vehicles.size());
        List<dataVehicles> bvehicles=new ArrayList<>();
        for(dataVehicles vehiclesmain:mvehicles){
            if(!vehiclesmain.getIsBot().equals("1")){
                bvehicles.add(vehiclesmain);
            }
        }

        vehicles=bvehicles;
        notifyDataSetChanged();
    }

    public void filterByReal(List<dataVehicles> mvehicles) {
        //todos losvehiculos
        // Log.e("SwitchVehicles", "Encendido "+" mvehicles: "+mvehicles.size());
        this.vehicles=mvehicles;
        notifyDataSetChanged();
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

