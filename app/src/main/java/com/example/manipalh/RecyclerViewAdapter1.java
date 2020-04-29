package com.example.manipalh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.ViewHolder>
{
    List<LAWclass>laWclass;

    public RecyclerViewAdapter1(List<LAWclass> laWclass)
    {
        this.laWclass = laWclass;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lawitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter1.ViewHolder holder, int position) {
        holder.law.setText(laWclass.get(position).getLaw());
    }

    @Override
    public int getItemCount()
    {
        return laWclass.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView law;
        View view;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            law=itemView.findViewById(R.id.lawitem);
        }
    }
}

