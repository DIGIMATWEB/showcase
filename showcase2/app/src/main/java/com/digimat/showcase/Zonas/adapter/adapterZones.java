package com.digimat.showcase.Zonas.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.digimat.showcase.R;
import com.digimat.showcase.Zonas.Dialogs.model.dataGetAllZones;
import com.digimat.showcase.Zonas.Dialogs.zonesConfiguratuon;

import java.util.List;

public class adapterZones extends RecyclerView.Adapter<adapterZones.ItemViewHolder> {
    private Context context;
    private List<dataGetAllZones> data;
    private  zonesConfiguratuon mview;
    public adapterZones(zonesConfiguratuon mview, List<dataGetAllZones> data, Context context) {
        this.mview=mview;
        this.data=data;
        this.context = context;
    }

    // Este método crea el ViewHolder para cada item
    @Override
    public adapterZones.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout para cada item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_zones, parent, false);
        return new adapterZones.ItemViewHolder(view);
    }

    // Este método enlaza los datos con el ViewHolder
    @Override
    public void onBindViewHolder(adapterZones.ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.nameZone.setText(data.get(position).getZoneName());
        holder.descZone.setText(data.get(position).getDescZone());
        if (data.get(position).getDotZoness().size()>1&&data.get(position).getRatio()!="1"){
            Glide.with(context).load(R.drawable.poligons).into(holder.typeZone);
            holder.ratio.setVisibility(View.GONE);
        }else{
            Glide.with(context).load(R.drawable.circles).into(holder.typeZone);
            holder.ratio.setVisibility(View.VISIBLE);
            holder.ratio.setText("R = "+data.get(position).getRatio()+" M");
        }
        holder.dotsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.optionConstrain.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Set optionConstrain to GONE after 4 seconds
                        holder.optionConstrain.setVisibility(View.GONE);
                    }
                }, 2000);
            }
        });
        holder.editTextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mview.senDotsEditor(data.get(position).getDotZoness());
                mview.sendToEditorZone(2);

            }
        });
        holder.eraseTextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mview.sendToEditorZone(3);
            }
        });
    }
    // Este método retorna la cantidad de items en la lista
    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView nameZone,descZone,ratio,editTextB,eraseTextB;
        private ImageView typeZone,dotsButton;
        private CardView optionConstrain;
        public ItemViewHolder(View itemView) {
            super(itemView);
            optionConstrain=itemView.findViewById(R.id.optionConstrain);
            nameZone=itemView.findViewById(R.id.nameZone);
            descZone=itemView.findViewById(R.id. descZone);
            ratio= itemView.findViewById(R.id.ratio);
            typeZone= itemView.findViewById(R.id.typeZone);
            dotsButton= itemView.findViewById(R.id. dotsButton);
            optionConstrain = itemView.findViewById(R.id.optionConstrain);
            editTextB = itemView.findViewById(R.id.editTextB);
            eraseTextB = itemView.findViewById(R.id.eraseTextB);
        }
    }
}
