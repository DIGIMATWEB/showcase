package com.digimat.showcase.Mas.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.Mas.view.masFrament;
import com.digimat.showcase.Menu.models.SetMenu.modelMenu;
import com.digimat.showcase.R;

import java.util.List;

public class adapterMenusExtras extends RecyclerView.Adapter<adapterMenusExtras.ViewHolder> {

    private Context context;
    private List<modelMenu> menusE;
    private masFrament mview;
    public adapterMenusExtras(masFrament mview, Context context, List<modelMenu> menusE) {
        this.context = context;
        this.menusE = menusE;
        this.mview=mview;
    }

    @NonNull
    @Override
    public adapterMenusExtras.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_moremenus, parent, false);
        return new adapterMenusExtras.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterMenusExtras.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        // Crear las listas dentro del método para que se genere una nueva para cada vista
        modelMenu item = menusE.get(position);

        // Obtener Drawable desde el nombre
        Drawable icon = item.getIconDrawable(context);

//        if (icon != null) {
//            holder.imageMenu.setImageDrawable(icon);
//        } else {
            // Si no encuentra el ícono, muestra uno por defecto
        if(position==0) {
            holder.imageMenu.setImageResource(R.drawable.sendnotification);
        }else if(position==1){
            holder.imageMenu.setImageResource(R.drawable.events);
        }else if(position==2){
            holder.imageMenu.setImageResource(R.drawable.tourista);
        }else if(position==3){
            holder.imageMenu.setImageResource(android.R.drawable.ic_menu_myplaces);
        }
//        }

        holder.nameMenu.setText(item.getPerfil());
        holder.imageGoMenu.setVisibility(View.GONE);
        holder.constrainmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mview.moveFragment(position,holder.nameMenu.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return menusE.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageMenu,imageGoMenu;
        private TextView nameMenu;
        private ConstraintLayout constrainmore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageMenu=itemView.findViewById(R.id.imageMenu);
            nameMenu=itemView.findViewById(R.id.nameMenu);
            imageGoMenu=itemView.findViewById(R.id. imageGoMenu);
            constrainmore = itemView.findViewById(R.id.constrainmore);
        }
    }
}