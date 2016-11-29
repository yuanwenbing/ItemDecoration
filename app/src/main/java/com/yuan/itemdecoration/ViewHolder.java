package com.yuan.itemdecoration;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by yuan on 29/11/2016.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public ViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.textView);
    }
}
