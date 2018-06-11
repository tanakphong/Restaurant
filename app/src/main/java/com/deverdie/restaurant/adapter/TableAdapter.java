package com.deverdie.restaurant.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.deverdie.restaurant.R;
import com.deverdie.restaurant.model.TableRes;

import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.TableViewHolder> {
    Context context;
    List<TableRes> tables;
    private ItemClickListener mClickListener;

    public TableAdapter(Context context,List<TableRes> tables){
        this.context = context;
        this.tables = tables;
    }

    @NonNull
    @Override
    public TableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.widget_cardview_activity_table_grid, parent, false);
        return new TableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableViewHolder holder, int position) {
        holder.code.setText(tables.get(position).getCode());
        holder.desc.setText(tables.get(position).getDesc());
//        holder.photo.setImageResource(tables.get(position).getPhotoId());
        Glide.with(context)
                .load(tables.get(position).getPhoto_path())
//                .apply(RequestOptions.circleCropTransform())
//                .apply(RequestOptions.fitCenterTransform())
                .into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return tables.size();
    }

    public class TableViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView code;
        TextView desc;
        ImageView photo;

        TableViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            code = itemView.findViewById(R.id.code);
            desc = itemView.findViewById(R.id.desc);
            photo = itemView.findViewById(R.id.photo);
            cv.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    // convenience method for getting data at click position
    public TableRes getItem(int id) {
        return tables.get(id);
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
