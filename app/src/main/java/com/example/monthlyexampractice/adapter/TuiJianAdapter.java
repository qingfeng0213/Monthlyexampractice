package com.example.monthlyexampractice.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.monthlyexampractice.R;
import com.example.monthlyexampractice.bean.HomeBean;

import java.util.List;

public class TuiJianAdapter extends RecyclerView.Adapter<TuiJianAdapter.TuijianHolder> {

    private final Context context;
    private final List<HomeBean.DataBean.TuijianBean.ListBeanX> tuijian;
    private final LayoutInflater layoutInflater;

    public TuiJianAdapter(Context context, List<HomeBean.DataBean.TuijianBean.ListBeanX> tuijian) {
        this.context = context;
        this.tuijian = tuijian;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TuijianHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.item_tuijian_item, viewGroup, false);
        TuijianHolder tuijianHolder = new TuijianHolder(view);
        return tuijianHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TuijianHolder tuijianHolder, int i) {
        Glide.with(context).load(tuijian.get(i).getImages()).into(tuijianHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return tuijian.size();
    }

    class TuijianHolder extends RecyclerView.ViewHolder{

        private final ImageView imageView;

        public TuijianHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
