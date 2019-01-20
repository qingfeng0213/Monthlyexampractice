package com.example.monthlyexampractice.login.loginmvp.view;

import com.example.monthlyexampractice.bean.LoginBean;

public interface ILoginView {
    void getViewData(LoginBean loginBean);
    void jumpActivity();
}
