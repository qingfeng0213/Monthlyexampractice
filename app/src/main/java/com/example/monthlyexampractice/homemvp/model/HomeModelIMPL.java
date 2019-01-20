package com.example.monthlyexampractice.homemvp.model;

import com.example.monthlyexampractice.bean.HomeBean;
import com.example.monthlyexampractice.network.HttpUrlUtils;

public class HomeModelIMPL implements IHomeModel {
    @Override
    public void getHomeData(String url, final Cteanview cteanview) {
        HttpUrlUtils.getInstance().doGet(url, HomeBean.class, new HttpUrlUtils.NetCallBack() {
            @Override
            public void onSuccess(Object oj) {
            cteanview.Succes(oj);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
