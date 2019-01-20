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

public class FenleiAdapter extends RecyclerView.Adapter<FenleiAdapter.FenleiHolder> {

    private final Context context;
    private final List<HomeBean.DataBean.FenleiBean> fenlei;
    private final LayoutInflater layoutInflater;

    public FenleiAdapter(Context context, List<HomeBean.DataBean.FenleiBean> fenlei) {
        this.context = context;
        this.fenlei = fenlei;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FenleiHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.item_fenlei_item, viewGroup, false);
        FenleiHolder fenleiHolder = new FenleiHolder(view);
        return fenleiHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FenleiHolder fenleiHolder, int i) {
        fenleiHolder.biao.setText(fenlei.get(i).getName());
        Glide.with(context).load(fenlei.get(i).getIcon()).into(fenleiHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return fenlei.size();
    }

    class FenleiHolder extends RecyclerView.ViewHolder{

        private final ImageView imageView;
        private final TextView biao;

        public FenleiHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            biao = itemView.findViewById(R.id.biao);
        }
    }
}
