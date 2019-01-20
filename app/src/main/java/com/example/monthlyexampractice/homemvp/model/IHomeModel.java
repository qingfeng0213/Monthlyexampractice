package com.example.monthlyexampractice.homemvp.model;



public interface IHomeModel {
    void getHomeData(String url,Cteanview cteanview);

    interface Cteanview{
        void Succes(Object data);
        void Fuils();
    }
}
