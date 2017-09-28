package com.lee.itemanimatordemo;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lee.itemanimatordemo.adapter.MyRecyclerViewAdapter;
import com.lee.itemanimatordemo.animator.RotateItemAnimator;
import com.lee.itemanimatordemo.animator.ScaleItemAnimator;
import com.lee.itemanimatordemo.animator.SlideLeftItemAnimator;
import com.lee.itemanimatordemo.bean.Data;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.delete)
    Button delete;
    @BindView(R.id.move)
    Button move;
    @BindView(R.id.rotate)
    RadioButton rotate;
    @BindView(R.id.scale)
    RadioButton scale;
    @BindView(R.id.slide)
    RadioButton slide;
    @BindView(R.id.radiogroup)
    RadioGroup radiogroup;

    private MyRecyclerViewAdapter adapter;
    private ArrayList<Data> datas;

    private RotateItemAnimator rotateItemAnimator;
    private SlideLeftItemAnimator slideLeftItemAnimator;
    private ScaleItemAnimator scaleItemAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        rotateItemAnimator = new RotateItemAnimator();
        slideLeftItemAnimator = new SlideLeftItemAnimator();
        scaleItemAnimator = new ScaleItemAnimator();

        recycler.setLayoutManager(new LinearLayoutManager(this));
        datas = new ArrayList<>();

        datas.add(new Data("hello1"));
        datas.add(new Data("hello2"));
        datas.add(new Data("hello3"));
        datas.add(new Data("hello4"));
        datas.add(new Data("hello5"));
        datas.add(new Data("hello6"));


        adapter = new MyRecyclerViewAdapter(this);
        recycler.setAdapter(adapter);

        adapter.setData(datas);

        recycler.setItemAnimator(rotateItemAnimator);
        recycler.getItemAnimator().setAddDuration(500);
        recycler.getItemAnimator().setChangeDuration(500);
        recycler.getItemAnimator().setRemoveDuration(500);
        recycler.getItemAnimator().setMoveDuration(500);

        add.setOnClickListener(this);
        delete.setOnClickListener(this);
        move.setOnClickListener(this);


        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int id = radioGroup.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.scale:
                        recycler.setItemAnimator(scaleItemAnimator);
                        break;
                    case R.id.rotate:
                        recycler.setItemAnimator(rotateItemAnimator);
                        break;
                    case R.id.slide:
                        recycler.setItemAnimator(slideLeftItemAnimator);
                        break;
                }

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                datas.add(datas.size(), new Data("hello" + (datas.size() + 1)));

                adapter.notifyItemInserted(datas.size());
                break;
            case R.id.delete:
                datas.remove(2);
                adapter.notifyItemRemoved(2);
                break;
            case R.id.move:
                adapter.notifyItemMoved(2, 3);
                break;
        }
    }
}
