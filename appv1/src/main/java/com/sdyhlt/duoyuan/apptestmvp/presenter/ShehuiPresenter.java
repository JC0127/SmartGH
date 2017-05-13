package com.sdyhlt.duoyuan.apptestmvp.presenter;

import com.sdyhlt.duoyuan.apptestmvp.bean.ShehuiBeans;
import com.sdyhlt.duoyuan.apptestmvp.model.IshehuiNewsmodel;
import com.sdyhlt.duoyuan.apptestmvp.model.ShehuiModel;
import com.sdyhlt.duoyuan.apptestmvp.view.interfaces.IshehuiShowView;

import java.util.List;

/**
 * Created by jingsheng on 2016/12/30.
 */

public class ShehuiPresenter {
    IshehuiShowView showView;
    IshehuiNewsmodel newsmodel=new ShehuiModel();

    public ShehuiPresenter(IshehuiShowView showView) {
        this.showView = showView;
    }

    public void fetch(){
        if (newsmodel!=null){
            newsmodel.loadNews(new IshehuiNewsmodel.NewsOnListener() {
                @Override
                public void onComplete(List<ShehuiBeans.ResultBean.DataBean> newsinfo) {
                    showView.showNews(newsinfo);
                }
            });
        }

    }
}
