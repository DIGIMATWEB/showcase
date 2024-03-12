package com.digimat.showcase.availableApps.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;
import com.digimat.showcase.availableApps.model.dataAvailableApps;
import com.digimat.showcase.availableApps.view.appsViewImpl;

import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder> {

    private List<dataAvailableApps> dataList;
    private appsViewImpl mview;
    private int mCurrentPosition = 0;

    public HorizontalAdapter(appsViewImpl mview , List<dataAvailableApps> dataList) {
        this.dataList = dataList;
        this.mview=mview;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = dataList.get(position).getNameApp();
        holder.nameApp.setText(name);
        if(dataList.get(position).getAvailable().equals("1")){
            holder.switchAvailable.setChecked(true);
        }else{
            holder.switchAvailable.setChecked(false);
        }



        holder.switchAvailable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Check if the switch is checked (ON) or unchecked (OFF)
                if (isChecked) {
                    mview.setAvailable(true, dataList.get(position).getNameApp());
                } else {
                    mview.setAvailable(false, dataList.get(position).getNameApp());
                }
            }
        });
        // Bind your data to the views in the item layout
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setCurrentPosition(int position) {
        mCurrentPosition = position;
        notifyDataSetChanged(); // Notify adapter of the data set change
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Declare your views here
        TextView nameApp;
        ImageView imageView;
        Switch switchAvailable;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameApp=itemView.findViewById(R.id.nameApp);
            switchAvailable=itemView.findViewById(R.id.switchAvailable);
            imageView=itemView.findViewById(R.id.imageView);
            // Initialize your views here
        }
    }
}
