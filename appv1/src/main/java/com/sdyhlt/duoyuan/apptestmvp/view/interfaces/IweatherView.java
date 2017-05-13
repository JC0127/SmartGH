package com.sdyhlt.duoyuan.apptestmvp.view.interfaces;

import com.sdyhlt.duoyuan.apptestmvp.bean.WeatherBeans;
import com.sdyhlt.duoyuan.apptestmvp.bean.WeixinBeans;

import java.util.List;

/**
 * Created by 王俊杰 on 2017/5/12.
 */

public interface IweatherView {
    void showView(List<WeatherBeans.ResultBean> listBeen);
    void showError();
}
