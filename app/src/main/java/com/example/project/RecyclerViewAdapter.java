package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Planet> planetList;

    public RecyclerViewAdapter(List<Planet> planetList) { this.planetList = planetList; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_items, parent, false));
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(planetList.get(position).getName());
        holder.size.setText(planetList.get(position).getSize());
        holder.category.setText(planetList.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

    public void setPlanets(List<Planet> items) {
        this.planetList = items;
    }
}

class ViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView size;
    public TextView category;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.text_name);
        size = itemView.findViewById(R.id.text_size);
        category = itemView.findViewById(R.id.text_category);
    }
}