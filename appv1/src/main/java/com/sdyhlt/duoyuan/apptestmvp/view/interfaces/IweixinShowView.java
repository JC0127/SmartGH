package com.sdyhlt.duoyuan.apptestmvp.view.interfaces;

import com.sdyhlt.duoyuan.apptestmvp.bean.WeixinBeans;

import java.util.List;

/**
 * Created by jingsheng on 2017/1/3.
 */

public interface IweixinShowView {
    void showView(List<WeixinBeans.ResultBean.ListBean> listBeen);
    void showError();
}
