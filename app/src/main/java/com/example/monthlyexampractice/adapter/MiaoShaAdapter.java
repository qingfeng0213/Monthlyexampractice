package com.example.monthlyexampractice.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.monthlyexampractice.R;
import com.example.monthlyexampractice.bean.HomeBean;

import java.util.List;

public class MiaoShaAdapter extends RecyclerView.Adapter<MiaoShaAdapter.MiaoShaHolder> {
    private final Context context;
    private final List<HomeBean.DataBean.MiaoshaBean.ListBean> miaosha;
    private final LayoutInflater layoutInflater;

    public MiaoShaAdapter(Context context, List<HomeBean.DataBean.MiaoshaBean.ListBean> miaosha) {
        this.context = context;
        this.miaosha = miaosha;
        layoutInflater = LayoutInflater.from(this.context);
    }

    @NonNull
    @Override
    public MiaoShaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.item_miaosha_item, viewGroup, false);
        MiaoShaHolder miaoShaHolder = new MiaoShaHolder(view);
        return miaoShaHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiaoShaHolder miaoShaHolder, int i) {
        miaoShaHolder.biao.setText(miaosha.get(i).getPrice());
        Glide.with(context).load(miaosha.get(i)).into(miaoShaHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return miaosha.size();
    }

    class MiaoShaHolder extends RecyclerView.ViewHolder{
        private final ImageView imageView;
        private final TextView biao;

        public MiaoShaHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            biao = itemView.findViewById(R.id.biao);
        }
    }
}
