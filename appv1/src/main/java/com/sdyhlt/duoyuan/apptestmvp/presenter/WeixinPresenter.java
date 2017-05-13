package com.sdyhlt.duoyuan.apptestmvp.presenter;

import com.sdyhlt.duoyuan.apptestmvp.bean.WeixinBeans;
import com.sdyhlt.duoyuan.apptestmvp.model.IweixinModule;
import com.sdyhlt.duoyuan.apptestmvp.model.WeixinModule;
import com.sdyhlt.duoyuan.apptestmvp.view.interfaces.IweixinShowView;

import java.util.List;

/**
 * Created by jingsheng on 2017/1/3.
 */

public class WeixinPresenter {
    IweixinShowView showView;
    IweixinModule module=new WeixinModule();

    public WeixinPresenter(IweixinShowView showView) {
        this.showView = showView;
    }
    public void fetch(int page){
        module.loadInfo(new IweixinModule.InfoOnListner() {
            @Override
            public void onComplete(List<WeixinBeans.ResultBean.ListBean> listBeen) {
                showView.showView(listBeen);
            }

            @Override
            public void error() {
                showView.showError();
            }
        },page);
    }
}
