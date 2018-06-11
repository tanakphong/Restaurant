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

import java.util.ArrayList;
import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.TableViewHolder> {
    private Context context;
    private List<TableRes.DataBean> tables = new ArrayList<>();
    private ItemClickListener mClickListener;

    public TableAdapter(Context context) {
        this.context = context;
    }

    public void add(TableRes.DataBean dataBean) {
        tables.add(dataBean);
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
        TableRes.DataBean table = getItem(position);
        holder.id.setText(table.getId());
        holder.code.setText(table.getCode());
        holder.desc.setText(table.getDesc());
//        holder.photo.setImageResource(tables.get(position).getPhotoId());
        Glide.with(context)
                .load(table.getPhoto_path())
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
        TextView id;
        TextView code;
        TextView desc;
        ImageView photo;

        TableViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            id = itemView.findViewById(R.id.id);
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
    public TableRes.DataBean getItem(int id) {
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
