package com.example.project;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
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