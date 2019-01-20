package com.example.monthlyexampractice.login.loginmvp.model;

import com.example.monthlyexampractice.bean.LoginBean;
import com.example.monthlyexampractice.network.HttpUrlUtils;

import java.util.Map;

public class LoginModelIMPL implements ILoginModel {
    @Override
    public void getData(String url, Map<String, String> parmas, final Cteanview cteanview) {
        HttpUrlUtils.getInstance().doPost(url, LoginBean.class, parmas, new HttpUrlUtils.NetCallBack() {
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
