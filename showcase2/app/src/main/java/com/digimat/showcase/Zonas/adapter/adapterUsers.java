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
import com.digimat.showcase.Zonas.model.getUsers.dataFullUsers;
import com.digimat.showcase.Zonas.view.Zonas;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class adapterUsers extends RecyclerView.Adapter<adapterUsers.ItemViewHolder> {
    private Context context;
    private Zonas mview;
    private List<dataFullUsers> usersAll;
        // Constructor del Adapter
    public adapterUsers(Zonas mview, List<dataFullUsers> usersAll, Context context) {
            this.mview=mview;
            this.usersAll=usersAll;
            this.context = context;
        }
        // Este método crea el ViewHolder para cada item
        @Override
        public adapterUsers.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // Inflamos el layout para cada item
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usrs, parent, false);
            return new adapterUsers.ItemViewHolder(view);
        }

        // Este método enlaza los datos con el ViewHolder
        @Override
        public void onBindViewHolder(adapterUsers.ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
                holder.textNameUsr.setText(usersAll.get(position).getName());
                holder.location.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LatLng locationUser=new LatLng(Double.valueOf(usersAll.get(position).getLatUser()),Double.valueOf(usersAll.get(position).getLongUser()));
                        mview.goUserLocation(locationUser);
                    }
                });
        }

        // Este método retorna la cantidad de items en la lista
        @Override
        public int getItemCount() {
            return usersAll.size();
        }

        // ViewHolder interno
        public static class ItemViewHolder extends RecyclerView.ViewHolder {
            private TextView textNameUsr;
            private ImageView location;

            public ItemViewHolder(View itemView) {
                super(itemView);
                textNameUsr=itemView.findViewById(R.id.textNameUsr);
                location=itemView.findViewById(R.id. location);
            }
        }
}
