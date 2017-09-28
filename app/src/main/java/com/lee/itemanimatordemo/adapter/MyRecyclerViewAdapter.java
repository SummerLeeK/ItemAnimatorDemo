package com.lee.itemanimatordemo.adapter;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lee.itemanimatordemo.R;
import com.lee.itemanimatordemo.bean.Data;
import com.lee.itemanimatordemo.viewholder.SimpleViewHolder;

import java.util.ArrayList;

import butterknife.BindView;


/**
 * Created by lee on 2017/9/27.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Data> data;

    private LayoutInflater inflater;
    private Context context;


    public MyRecyclerViewAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<Data> data) {
        this.data=null;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimpleViewHolder(inflater.inflate(R.layout.simple_view_holder_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SimpleViewHolder) holder).bindViewHolder(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }
}
