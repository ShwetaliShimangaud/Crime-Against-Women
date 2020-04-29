package com.example.manipalh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter3 extends RecyclerView.Adapter<RecyclerViewAdapter3.ViewHolder>
{
    List<VREPORT>vreport;

    public RecyclerViewAdapter3(List<VREPORT> vreport) {
        this.vreport = vreport;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter3.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reportitem, parent, false);
        RecyclerViewAdapter3.ViewHolder viewHolder = new RecyclerViewAdapter3.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter3.ViewHolder holder, int position) {
        holder.rv.setText(vreport.get(position).getReport());
    }
    @Override
    public int getItemCount() {
        return vreport.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView rv;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv=itemView.findViewById(R.id.reporttext);
        }
    }
}
