package com.sdyhlt.duoyuan.apptestmvp.model;

import com.sdyhlt.duoyuan.apptestmvp.bean.HuoChebean;

import java.util.List;

/**
 * Created by jingsheng on 2017/2/9.
 */

public interface ItrainZDmodel {

    void loadeInfo(infoListener listener,String startAdd,String endAdd);
    void loadeInfo(infoListener listener,String cheCi);
    interface infoListener{
        void onComplete(List<HuoChebean.ResultBean> info);
        void onError(int code);
    }
}
