package com.example.monthlyexampractice.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.monthlyexampractice.R;
import com.example.monthlyexampractice.adapter.HomeAdapter;
import com.example.monthlyexampractice.bean.HomeBean;
import com.example.monthlyexampractice.homemvp.presenter.HomePresenterIMPL;
import com.example.monthlyexampractice.homemvp.view.IHomeView;
import com.recker.flybanner.FlyBanner;
import com.zhy.view.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements IHomeView {

    private RecyclerView homerecy;
    private FlyBanner flyBanner;
    private ArrayList<String> list;

    private ArrayList<String> strings;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefrag, container, false);
        homerecy = view.findViewById(R.id.homerecy);
        flyBanner = view.findViewById(R.id.flybanner);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        homerecy.setLayoutManager(linearLayoutManager);
        homerecy.setNestedScrollingEnabled(false);

        HomePresenterIMPL homePresenterIMPL = new HomePresenterIMPL(this);
        homePresenterIMPL.getHomeModelData();
        //创建数组存放网络图片
        list = new ArrayList<>();
        list.add("http://www.zhaoapi.cn/images/quarter/ad1.png");
        list.add("http://www.zhaoapi.cn/images/quarter/ad2.png");
        list.add("http://www.zhaoapi.cn/images/quarter/ad3.png");
        list.add("http://www.zhaoapi.cn/images/quarter/ad4.png");
        flyBanner.setImagesUrl(list);
        return view;
    }


    @Override
    public void getPreData(Object obj) {
        HomeBean homeBean = (HomeBean) obj;
        List<HomeBean.DataBean> list = new ArrayList<>();
        list.add(homeBean.getData());
        HomeAdapter homeAdapter = new HomeAdapter(getActivity(),list);
        homerecy.setAdapter(homeAdapter);
    }
}
