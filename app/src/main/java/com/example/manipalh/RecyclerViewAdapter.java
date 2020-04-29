package com.example.manipalh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<FAQclass>faQclass;    List<FAQclass>userlist1;
public RecyclerViewAdapter(List<FAQclass> faQclass)
    {
        this.faQclass=faQclass;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.faqitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

        holder.faq.setText(faQclass.get(position).getQa());
    }

    @Override
    public int getItemCount() {
        return faQclass.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    TextView faq;
    View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            faq=itemView.findViewById(R.id.queitem);
        }
    }
}
