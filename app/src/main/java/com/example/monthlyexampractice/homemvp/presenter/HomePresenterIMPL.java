package com.example.monthlyexampractice.homemvp.presenter;

import com.example.monthlyexampractice.fragment.HomeFragment;
import com.example.monthlyexampractice.homemvp.model.HomeModelIMPL;
import com.example.monthlyexampractice.homemvp.model.IHomeModel;

public class HomePresenterIMPL implements IHomePresenter {
    HomeFragment hfrag;
    private final HomeModelIMPL homeModelIMPL;
    String url = "http://www.zhaoapi.cn/home/getHome";

    public HomePresenterIMPL(HomeFragment hfrag) {
        this.hfrag = hfrag;
        homeModelIMPL = new HomeModelIMPL();
    }

    @Override
    public void getHomeModelData() {
        homeModelIMPL.getHomeData(url, new IHomeModel.Cteanview() {
            @Override
            public void Succes(Object data) {
                hfrag.getPreData(data);
            }

            @Override
            public void Fuils() {

            }
        });
    }
}
