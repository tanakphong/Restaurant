package com.deverdie.restaurant.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.deverdie.restaurant.R;
import com.deverdie.restaurant.model.MenuRes;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> implements Filterable {
    private Context context;
    private List<MenuRes.DataBean> data = new ArrayList<>();
    private List<MenuRes.DataBean> dataFiltered = new ArrayList<>();
    private ItemClickListener mClickListener;

    public MenuAdapter(Context context) {
        this.context = context;
    }

    public void add(MenuRes.DataBean menuRes) {
        data.add(menuRes);
        dataFiltered.add(menuRes);

    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.widget_cardview_activity_menu, parent, false);
        return new MenuAdapter.MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuRes.DataBean item = getItem(position);
        Glide.with(context)
                .load(item.getPhoto())
                .into(holder.photo);
        holder.desc.setText(item.getDesc());
        holder.code.setText(item.getCode());
        holder.price.setText(item.getPrice());

    }

    @Override
    public int getItemCount() {
        return dataFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    dataFiltered = data;
                } else {
                    List<MenuRes.DataBean> filteredList = new ArrayList<>();
                    for (MenuRes.DataBean row : dataFiltered) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getDesc().toLowerCase().contains(charString.toLowerCase()) || row.getCode().contains(charString)) {
                            filteredList.add(row);
                        }
                    }

                    dataFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = dataFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                dataFiltered = (ArrayList<MenuRes.DataBean>) results.values;
                notifyDataSetChanged();
            }
        };
    }


    public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        ImageView photo;
        TextView desc;
        TextView code;
        TextView price;

        MenuViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            photo = itemView.findViewById(R.id.photo);
            desc = itemView.findViewById(R.id.desc);
            code = itemView.findViewById(R.id.code);
            price = itemView.findViewById(R.id.price);
            cv.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());

        }
    }


    // convenience method for getting data at click position
    public MenuRes.DataBean getItem(int id) {
        return dataFiltered.get(id);
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
