package com.lee.itemanimatordemo.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lee.itemanimatordemo.R;
import com.lee.itemanimatordemo.bean.Data;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lee on 2017/9/27.
 */

public class SimpleViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_title)
    TextView tvTitle;


    public SimpleViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindViewHolder(Data data) {
        tvTitle.setText(data.getData());
    }
}
