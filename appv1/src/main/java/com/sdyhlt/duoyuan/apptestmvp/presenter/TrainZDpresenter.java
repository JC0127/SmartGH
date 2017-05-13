package com.sdyhlt.duoyuan.apptestmvp.presenter;

import com.sdyhlt.duoyuan.apptestmvp.bean.HuoChebean;
import com.sdyhlt.duoyuan.apptestmvp.model.ItrainZDmodel;
import com.sdyhlt.duoyuan.apptestmvp.model.TrainZDmodel;
import com.sdyhlt.duoyuan.apptestmvp.view.interfaces.IItemSelectZd;

import java.util.List;

/**
 * Created by jingsheng on 2017/2/9.
 */

public class TrainZDpresenter {
    IItemSelectZd views;
    ItrainZDmodel zDmodel=new TrainZDmodel();

    public TrainZDpresenter(IItemSelectZd views) {
        this.views = views;
    }

    public void fetch(String startAdd,String endAdd){
        zDmodel.loadeInfo(new ItrainZDmodel.infoListener() {
            @Override
            public void onComplete(List<HuoChebean.ResultBean> info) {
                views.showInfo(info);
            }

            @Override
            public void onError(int code) {
                views.showError(code);
            }
        },startAdd,endAdd);
    }

    public void fetch(String cheCi){
        zDmodel.loadeInfo(new ItrainZDmodel.infoListener() {
            @Override
            public void onComplete(List<HuoChebean.ResultBean> info) {
                views.showInfo(info);
            }

            @Override
            public void onError(int code) {
                views.showError(code);
            }
        },cheCi);
    }
}
