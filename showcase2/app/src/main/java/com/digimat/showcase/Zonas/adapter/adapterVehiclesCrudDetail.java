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
import com.digimat.showcase.Zonas.model.getVehicles.dotVehiclesPath;
import com.digimat.showcase.Zonas.view.Zonas;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class adapterVehiclesCrudDetail extends RecyclerView.Adapter<adapterVehiclesCrudDetail.ItemViewHolder> {
    private Context context;
    private Zonas mview;
    private List<dotVehiclesPath> pathDots=new ArrayList<>();
    private Boolean aNewDotIsAdded;
    public adapterVehiclesCrudDetail(Zonas mview, Context context, String path) {
        this.mview=mview;
        aNewDotIsAdded=false;
        pathDots.clear();
        Gson gson=new Gson();
        Type listType = new TypeToken<List<dotVehiclesPath>>() {}.getType();

        // Convertir el JSON a una lista de dotVehiclesPath
        List<dotVehiclesPath> vehiclePathList = gson.fromJson(path, listType);

        // Verificar el resultado
        if (vehiclePathList != null) {
            for (dotVehiclesPath dot : vehiclePathList) {
                pathDots.add(dot);
                System.out.println("Latitud: " + dot.getLatitud());
                System.out.println("Longitud: " + dot.getLongitud());
            }

        } else {
            pathDots=new ArrayList<>();
        //    System.out.println("El JSON no pudo ser deserializado en una lista.");
        }
    }

    public  void UpdateView(List<dotVehiclesPath> dotPath) {
        this.aNewDotIsAdded=false;
        this.pathDots=dotPath;
        notifyDataSetChanged();
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
        holder.editTextLat.setText(pathDots.get(position).getLatitud());
        holder.editTextLong.setText(pathDots.get(position).getLongitud());
        if(position==pathDots.size()-1) {
            if (aNewDotIsAdded) {
                holder.dot_add.setVisibility(View.VISIBLE);
                holder.dot_remove.setVisibility(View.VISIBLE);
                holder.dragButton.setVisibility(View.GONE);
            } else {
                holder.dot_add.setVisibility(View.GONE);
                holder.dot_remove.setVisibility(View.GONE);
                holder.dragButton.setVisibility(View.VISIBLE);
            }
        }
        holder.dot_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mview.saveNewDotV(pathDots,position);
            }
        });
        holder.dot_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mview.removeNewDotV(pathDots,position);
            }
        });
        holder.foundDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mview.editDotVehicle(pathDots,position,pathDots.get(position).getLatitud(),pathDots.get(position).getLongitud());
            }
        });
        mview.drawTempPoliline(pathDots);
    }

    // Este método retorna la cantidad de items en la lista
    @Override
    public int getItemCount() {
        return pathDots.size();
    }

    public void updateDotPosition(LatLng finalPosition) {
         if(!pathDots.isEmpty()) {
                    pathDots.set(pathDots.size() - 1, new dotVehiclesPath(String.valueOf(finalPosition.latitude), String.valueOf(finalPosition.longitude)));
            }else{
                pathDots.add( new dotVehiclesPath(String.valueOf(finalPosition.latitude), String.valueOf(finalPosition.longitude)));
            }
                mview.updateAfterScrollMarkerV(pathDots);
                notifyDataSetChanged();
    }

    public void addDot(LatLng position) {
          pathDots.add( new dotVehiclesPath(String.valueOf(position.latitude), String.valueOf(position.longitude)));
        aNewDotIsAdded=true;
        notifyDataSetChanged();
    }

    public void notifyRemoved(int position) {
        pathDots.remove(position);
        // Notify the adapter about the removed item
        notifyItemRemoved(position);
        // Notify the adapter to update the positions of the remaining items
        notifyItemRangeChanged(position, pathDots.size());
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView editTextLong,editTextLat;
        ImageView dragButton,dot_add,dot_remove,foundDot;
        public ItemViewHolder(View itemView) {
            super(itemView);
            editTextLong = itemView.findViewById(R.id.editTextLong);
            editTextLat = itemView.findViewById(R.id.editTextLat);
            dragButton = itemView.findViewById(R.id.dragButton);
            dot_add = itemView.findViewById(R.id.dot_add);
            dot_remove = itemView.findViewById(R.id.dot_remove);
            foundDot = itemView.findViewById(R.id.foundDot);
        }
    }
}