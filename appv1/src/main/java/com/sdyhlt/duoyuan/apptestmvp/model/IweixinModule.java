package com.sdyhlt.duoyuan.apptestmvp.model;

import com.sdyhlt.duoyuan.apptestmvp.bean.WeixinBeans;

import java.util.List;

/**
 * Created by jingsheng on 2017/1/3.
 */

public interface IweixinModule {

    void loadInfo(InfoOnListner onListner,int pages);
    interface InfoOnListner{
        void onComplete(List<WeixinBeans.ResultBean.ListBean> listBeen);
        void error();
    }
}
