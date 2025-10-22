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
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.digimat.showcase.Menu.models.SetMenu.modelMenu;
import com.digimat.showcase.R;

import java.util.List;

public class adapterMenus  extends RecyclerView.Adapter<adapterMenus.ViewHolder> {

private Context context;
private List<modelMenu> menusP;


public adapterMenus(Context context, List<modelMenu> menusP) {
    this.context = context;
    this.menusP=menusP;
}

@NonNull
@Override
public adapterMenus.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_moremenus, parent, false);
    return new adapterMenus.ViewHolder(view);
}

    @Override
    public void onBindViewHolder(@NonNull adapterMenus.ViewHolder holder, final int position) {
        modelMenu item = menusP.get(position);

        // Obtener Drawable desde el nombre
        Drawable icon = item.getIconDrawable(context);

        if (icon != null) {
            holder.imageMenu.setImageDrawable(icon);
        } else {
            // Si no encuentra el ícono, muestra uno por defecto
            holder.imageMenu.setImageResource(android.R.drawable.ic_menu_help);
        }

        holder.nameMenu.setText(item.getPerfil());
        holder.imageGoMenu.setVisibility(View.GONE);
    }

@Override
public int getItemCount() {
    return menusP.size();
}
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageMenu,imageGoMenu;
        private TextView nameMenu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageMenu=itemView.findViewById(R.id.imageMenu);
            nameMenu=itemView.findViewById(R.id.nameMenu);
            imageGoMenu=itemView.findViewById(R.id. imageGoMenu);
        }
    }
}