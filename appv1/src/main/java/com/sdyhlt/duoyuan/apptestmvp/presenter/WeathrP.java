package com.sdyhlt.duoyuan.apptestmvp.presenter;

import android.content.Context;

import com.sdyhlt.duoyuan.apptestmvp.bean.WeatherBeans;
import com.sdyhlt.duoyuan.apptestmvp.bean.WeixinBeans;
import com.sdyhlt.duoyuan.apptestmvp.model.IweatherModel;
import com.sdyhlt.duoyuan.apptestmvp.model.IweixinModule;
import com.sdyhlt.duoyuan.apptestmvp.model.WeatherModel;
import com.sdyhlt.duoyuan.apptestmvp.view.interfaces.IweatherView;

import java.util.List;

/**
 * Created by 王俊杰 on 2017/5/12.
 */

public class WeathrP {
    IweatherView view;
    IweatherModel model=new WeatherModel();
    Context context;

    public WeathrP(IweatherView view, Context context) {
        this.view = view;
        this.context=context;
    }
    public void fetch(String page){
        model.loadInfo(new IweatherModel.InfoOnListner() {
            @Override
            public void onComplete(List<WeatherBeans.ResultBean> listBeen) {
                view.showView(listBeen);
            }

            @Override
            public void error() {
                view.showError();
            }
        },page,context);
    }

}
