package com.digimat.showcase.Profile.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;

public class adapterProfile extends RecyclerView.Adapter<adapterProfile.ViewHolder> {

    private Context context;


    public adapterProfile(Context context) {
        //this.puenteFechas = puenteFechas;
        this.context = context;
    }

    @NonNull
    @Override
    public adapterProfile.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile, parent, false);
        return new adapterProfile.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterProfile.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        // Crear las listas dentro del método para que se genere una nueva para cada vista
        holder.iconProfile.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.profile_map));
        if(position==0){
            holder.textDescription.setText("Nombre");
        }else if(position==1){
            holder.textDescription.setText("Rol");
        }else if(position==2){
            holder.textDescription.setText("Comunidad");
        }else if(position==3){
            holder.textDescription.setText("Colonia");
        }else if(position==4) {
            holder.textDescription.setText("Transporte");
        }else{
            holder.textDescription.setText("Tramites");
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconProfile;
        TextView textDescription;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconProfile=itemView.findViewById(R.id.iconProfile);
            textDescription=itemView.findViewById(R.id.textDescription);
        }
    }
}