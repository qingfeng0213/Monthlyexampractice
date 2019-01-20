package com.example.monthlyexampractice.login.loginmvp.model;

import java.util.Map;

public interface ILoginModel {
    void getData(String url, Map<String ,String > parmas,Cteanview cteanview);

    interface Cteanview{
        void Succes(Object data);
        void Fuils();
    }
}
