package com.sdyhlt.duoyuan.apptestmvp.model;

import android.content.Context;

import com.sdyhlt.duoyuan.apptestmvp.bean.WeatherBeans;
import com.sdyhlt.duoyuan.apptestmvp.bean.WeixinBeans;

import java.util.List;

/**
 * Created by 王俊杰 on 2017/5/12.
 */

public interface IweatherModel {
    void loadInfo(IweatherModel.InfoOnListner onListner, String pages,Context c);
    interface InfoOnListner{
        void onComplete(List<WeatherBeans.ResultBean> listBeen);
        void error();
    }
}
