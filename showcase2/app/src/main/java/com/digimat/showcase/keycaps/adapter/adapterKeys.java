package com.digimat.showcase.keycaps.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;
import com.digimat.showcase.keycaps.model.keysItems;

import java.util.List;

public class adapterKeys extends RecyclerView.Adapter<adapterKeys.FoodViewHolder> {

    List<keysItems> foodList;

    public adapterKeys(List<keysItems> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_keys, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        keysItems item = foodList.get(position);
//        holder.name.setText(item.name);
//        holder.price.setText("$" + item.price);
//        holder.rating.setRating(item.rating);
//        holder.image.setImageResource(item.imageResId);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    static class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        RatingBar rating;
        ImageView image;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
//            name = itemView.findViewById(R.id.foodName);
//            price = itemView.findViewById(R.id.foodPrice);
//            rating = itemView.findViewById(R.id.foodRating);
//            image = itemView.findViewById(R.id.foodImage);
        }
    }
}