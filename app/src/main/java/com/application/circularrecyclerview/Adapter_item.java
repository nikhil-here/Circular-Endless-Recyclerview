package com.application.circularrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_item extends RecyclerView.Adapter<Adapter_item.ViewHolder> {

    private int noOfItems;
    private int maxItems;


    public Adapter_item(int noOfItems) {
        this.noOfItems = noOfItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int linearPosition) {
        //calculating position of item which need to shown
        int circularPosition = linearPosition % noOfItems;
        holder.tvHeadline.setText("Item "+(circularPosition + 1));
        holder.tvBody.setText("Position : "+circularPosition);
    }

    @Override
    public int getItemCount() {
        //List will not be initiated if noOfItems is 0
        if (noOfItems == 0)
        {
             maxItems = 0;
        }else{
            maxItems = Integer.MAX_VALUE;
        }
        return maxItems;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvHeadline, tvBody;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHeadline = itemView.findViewById(R.id.rv_item_tv_headline);
            tvBody = itemView.findViewById(R.id.rv_item_tv_body);
        }
    }
}
