package com.digimat.showcase.Mas.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.Mas.view.masFrament;
import com.digimat.showcase.R;

public class adapterInfo extends RecyclerView.Adapter<adapterInfo.ViewHolder> {

    private Context context;
    private masFrament mview;


    public adapterInfo(masFrament mview, Context context) {
        this.context = context;
        this.mview=mview;
    }

    @NonNull
    @Override
    public adapterInfo.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_moremenus, parent, false);
        return new adapterInfo.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterInfo.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        // Crear las listas dentro del método para que se genere una nueva para cada vista
//        modelMenu item = menusE.get(position);
//
//        // Obtener Drawable desde el nombre
//        Drawable icon = item.getIconDrawable(context);

      if (position == 1) {
        holder.imageMenu.setImageDrawable( context.getResources().getDrawable(android.R.drawable.ic_menu_info_details));
          holder.nameMenu.setText("Politica");
       } else {
//            // Si no encuentra el ícono, muestra uno por defecto
//            holder.imageMenu.setImageResource(android.R.drawable.ic_menu_help);
          holder.imageMenu.setImageDrawable( context.getResources().getDrawable(R.drawable.inf));
          holder.nameMenu.setText("Tutorial");
        }

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
        return 2;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageMenu, imageGoMenu;
        private TextView nameMenu;
        private ConstraintLayout constrainmore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageMenu = itemView.findViewById(R.id.imageMenu);
            nameMenu = itemView.findViewById(R.id.nameMenu);
            imageGoMenu = itemView.findViewById(R.id.imageGoMenu);
            constrainmore = itemView.findViewById(R.id.constrainmore);
        }
    }
}