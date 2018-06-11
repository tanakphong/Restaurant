package com.deverdie.restaurant.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.deverdie.restaurant.R;
import com.deverdie.restaurant.model.MainMenuRes;

import java.util.ArrayList;
import java.util.List;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.MainMenuViewHolder> {
    private List<MainMenuRes> mainMenu = new ArrayList<>();
    private ItemClickListener mClickListener;

    public void add(MainMenuRes mainMenuRes) {
        mainMenu.add(mainMenuRes);
    }

    @NonNull
    @Override
    public MainMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_cardview_activity_main, parent, false);
        return new MainMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainMenuViewHolder holder, int position) {
        MainMenuRes item = getItem(position);
        holder.icon.setImageResource(item.getIco());
        holder.desc.setText(item.getDesc());
    }

    @Override
    public int getItemCount() {
        return mainMenu.size();
    }

    public class MainMenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        ImageView icon;
        TextView desc;

        MainMenuViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            icon = itemView.findViewById(R.id.icon);
            desc = itemView.findViewById(R.id.desc);
            cv.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());

        }
    }


    // convenience method for getting data at click position
    private MainMenuRes getItem(int id) {
        return mainMenu.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
