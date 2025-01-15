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
import com.digimat.showcase.Zonas.Dialogs.model.dotZonesm;
import com.digimat.showcase.Zonas.view.Zonas;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class adapterCrudZones extends RecyclerView.Adapter<adapterCrudZones.ItemViewHolder> {
    private Context context;
    private List<dotZonesm> dotZoness=new ArrayList<>();
    private Boolean aNewDotIsAdded;
    private Zonas mview;
    public adapterCrudZones(Zonas mview, List<dotZonesm> dotZoness, Context context) {
        this.mview=mview;
        this.dotZoness=dotZoness;
        this.context = context;
        aNewDotIsAdded=false;
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
    public void onBindViewHolder(adapterCrudZones.ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.editTextLat.setText(dotZoness.get(position).getLatitud());
        holder.editTextLong.setText(dotZoness.get(position).getLongitud());
        if(position==dotZoness.size()-1) {
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
                mview.saveNewDot(dotZoness,position);
            }
        });
        holder.dot_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mview.removeNewDot(dotZoness,position);
            }
        });
        holder.foundDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mview.editDotZone(dotZoness,position);
            }
        });
        mview.drawTempZone(dotZoness);
    }
    // Este método retorna la cantidad de items en la lista
    @Override
    public int getItemCount() {
        return dotZoness.size();
    }

    public void addDot(LatLng position) {
        dotZoness.add( new dotZonesm(String.valueOf(position.latitude), String.valueOf(position.longitude)));
        aNewDotIsAdded=true;
        notifyDataSetChanged();
    }

    public void updateDotPosition(LatLng finalPosition) {
        if(!dotZoness.isEmpty()) {
            dotZoness.set(dotZoness.size() - 1, new dotZonesm(String.valueOf(finalPosition.latitude), String.valueOf(finalPosition.longitude)));
        }else{
            dotZoness.add( new dotZonesm(String.valueOf(finalPosition.latitude), String.valueOf(finalPosition.longitude)));
        }
        mview.updateAfterScrollMarker(dotZoness);
        notifyDataSetChanged();
    }
    public  void UpdateView(List<dotZonesm> newDots) {
        this.aNewDotIsAdded=false;
        this.dotZoness=newDots;
        notifyDataSetChanged();
    }

    public void notifyRemoved(int position) {
        dotZoness.remove(position);
        // Notify the adapter about the removed item
        notifyItemRemoved(position);
        // Notify the adapter to update the positions of the remaining items
        notifyItemRangeChanged(position, dotZoness.size());
    }

    public void notifyRemovedOnSwipe(int position) {
        dotZoness.remove(position);
        // Notify the adapter about the removed item
        notifyItemRemoved(position);
        // Notify the adapter to update the positions of the remaining items
        notifyItemRangeChanged(position, dotZoness.size());
        mview.updateTempZone(dotZoness);
    }

    public void updateAtSingularDot(List<dotZonesm> dotZoness) {
        this.aNewDotIsAdded=false;
        this.dotZoness=dotZoness;
        notifyDataSetChanged();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView editTextLong,editTextLat;
        ImageView dragButton,dot_add,dot_remove,foundDot;
        public ItemViewHolder(View itemView) {
            super(itemView);
            editTextLong = itemView.findViewById(R.id.editTextLong);
            editTextLat= itemView.findViewById(R.id.editTextLat);
            dragButton= itemView.findViewById(R.id.dragButton);
            dot_add= itemView.findViewById(R.id.dot_add);
            dot_remove= itemView.findViewById(R.id.dot_remove);
            foundDot = itemView.findViewById(R.id. foundDot);
        }
    }
}
