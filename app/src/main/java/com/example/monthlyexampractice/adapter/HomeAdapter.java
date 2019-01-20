package com.example.monthlyexampractice.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.monthlyexampractice.R;
import com.example.monthlyexampractice.bean.HomeBean;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<HomeBean.DataBean> list;
    private final LayoutInflater layoutInflater;
    private final int FENLEI = 1;
    private final int MIAOSHA = 2;
    private final int TUIJIAN = 3;
    private List<HomeBean.DataBean.FenleiBean> fenlei;
    private List<HomeBean.DataBean.MiaoshaBean.ListBean> miaosha;
    private List<HomeBean.DataBean.TuijianBean.ListBeanX> tuijian;

    public HomeAdapter(Context context, List<HomeBean.DataBean> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    //获取当前条目视图类型
    @Override
    public int getItemViewType(int position) {
        switch (position)
        {
            case 0:
                return FENLEI;
            case 1:
                return MIAOSHA;
        }
        return TUIJIAN;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mview;
        if (i == FENLEI) {
            mview = View.inflate(viewGroup.getContext(), R.layout.item_fenlei, null);
            return new Item1ViewHodel(mview);
        }else if (i == MIAOSHA){
            return new Item2ViewHolder(layoutInflater.inflate(R.layout.item_miaosha,viewGroup,false));
        }else {
            return new Item3ViewHolder(layoutInflater.inflate(R.layout.item_tuijian,viewGroup,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof Item1ViewHodel) {

            fenlei = list.get(i).getFenlei();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 10);
            ((Item1ViewHodel) viewHolder).rv.setLayoutManager(gridLayoutManager);
            FenleiAdapter fenleiAdapter = new FenleiAdapter(context,fenlei);
            ((Item1ViewHodel) viewHolder).rv.setAdapter(fenleiAdapter);

        }if (viewHolder instanceof Item2ViewHolder){

            miaosha = this.list.get(i).getMiaosha().getList();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            ((Item2ViewHolder) viewHolder).rv2.setLayoutManager(linearLayoutManager);
            MiaoShaAdapter miaoShaAdapter = new MiaoShaAdapter(context, miaosha);
            ((Item2ViewHolder) viewHolder).rv2.setAdapter(miaoShaAdapter);

        }if (viewHolder instanceof Item3ViewHolder){
            tuijian = this.list.get(i).getTuijian().getList();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            ((Item3ViewHolder) viewHolder).rv3.setLayoutManager(linearLayoutManager);
            TuiJianAdapter tuiJianAdapter = new TuiJianAdapter(context,tuijian);
            ((Item3ViewHolder) viewHolder).rv3.setAdapter(tuiJianAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Item1ViewHodel extends RecyclerView.ViewHolder{
        RecyclerView rv;
        public Item1ViewHodel(@NonNull View itemView) {
            super(itemView);
            rv = itemView.findViewById(R.id.rv);
        }
    }
    class Item2ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView rv2;

        public Item2ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv2 = itemView.findViewById(R.id.rv);
        }
    }
    class Item3ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView rv3;

        public Item3ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv3 = itemView.findViewById(R.id.rv);
        }
    }
}
