package com.digimat.showcase.Tutorial.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.digimat.showcase.R;

public class adapterDots extends RecyclerView.Adapter<adapterDots.ViewHolder> {

    private Context context;
    private Integer postionDot;


    public adapterDots(Integer postionDot, Context context) {
        this.context = context;
        this.postionDot=postionDot;
    }

    @NonNull
    @Override
    public adapterDots.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dots_pager, parent, false);
        return new adapterDots.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterDots.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        ViewGroup.LayoutParams params = holder.dot.getLayoutParams();

        // Convert dp to px
        int widthActive = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 12, context.getResources().getDisplayMetrics());
        int widthInactive = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 6, context.getResources().getDisplayMetrics());

        // Apply width based on selected position
        params.width = (position == postionDot) ? widthActive : widthInactive;
        holder.dot.setLayoutParams(params);

        // Optional: change color too if you want
        int color = (position == postionDot) ? Color.BLACK : Color.parseColor("#C8C8C8");
        ((CardView) holder.dot).setCardBackgroundColor(color);
    }
    @Override
    public int getItemCount() {
        return 3    ;
    }

    public void notifyNext(Integer postionDot) {
        this.postionDot=postionDot;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView dot;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dot= itemView.findViewById(R.id.dot);
        }
    }
    }
