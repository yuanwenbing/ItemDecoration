package com.yuan.itemdecoration;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 29/11/2016.
 */
public class ListAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<String> mDatas = new ArrayList<>();


    public ListAdapter(List<String> datas) {
        this.mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(mDatas.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
