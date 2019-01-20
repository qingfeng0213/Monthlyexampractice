package com.example.monthlyexampractice.login.loginmvp.presenter;

import com.example.monthlyexampractice.bean.LoginBean;
import com.example.monthlyexampractice.login.LoginActivity;
import com.example.monthlyexampractice.login.loginmvp.model.ILoginModel;
import com.example.monthlyexampractice.login.loginmvp.model.LoginModelIMPL;

import java.util.HashMap;
import java.util.Map;

public class LoginPresenterIMPL implements ILoginPresenter {

    LoginActivity lView;
    private final LoginModelIMPL loginModelIMPL;
    String url = "http://www.zhaoapi.cn/user/login";

    public LoginPresenterIMPL(LoginActivity lView) {
        this.lView = lView;
        loginModelIMPL = new LoginModelIMPL();
    }

    @Override
    public void getModelData(String name, String pwd) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile",name);
        map.put("password",pwd);
        loginModelIMPL.getData(url, map, new ILoginModel.Cteanview() {
            @Override
            public void Succes(Object data) {
                LoginBean bean = (LoginBean) data;
                lView.getViewData(bean);
                if (bean.getCode().equals("0")){
                    lView.jumpActivity();
                }
            }

            @Override
            public void Fuils() {

            }
        });
    }
}
