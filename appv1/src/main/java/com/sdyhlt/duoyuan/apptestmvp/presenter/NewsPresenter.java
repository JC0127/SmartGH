package com.sdyhlt.duoyuan.apptestmvp.presenter;

import com.sdyhlt.duoyuan.apptestmvp.bean.TopNews;
import com.sdyhlt.duoyuan.apptestmvp.model.ItopNewsmodel;
import com.sdyhlt.duoyuan.apptestmvp.model.TopNewsModel;
import com.sdyhlt.duoyuan.apptestmvp.view.interfaces.ITopNewsshowView;

import java.util.List;

/**
 * Created by jingsheng on 2016/12/25.
 */

public class NewsPresenter {

    ITopNewsshowView mShowView;

    ItopNewsmodel mMImodel=new TopNewsModel();

    public NewsPresenter(ITopNewsshowView mShowView) {
        this.mShowView = mShowView;
    }

    public void fetch(){
        if (mMImodel!=null){
            mMImodel.loadNews(new ItopNewsmodel.NewsOnListener() {
                @Override
                public void onComplete(List<TopNews.ResultBean.DataBean> newinfo) {
                    mShowView.showNews(newinfo);
                }
            });
        }

    }

}
