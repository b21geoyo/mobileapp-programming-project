package com.example.project;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Items> itemsList;

    public MyAdapter(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_items, parent, false));
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(itemsList.get(position).getName());
        holder.size.setText(itemsList.get(position).getSize());
        holder.category.setText(itemsList.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public void setItemsList(List<Items> items) {
        this.itemsList = items;
    }
}