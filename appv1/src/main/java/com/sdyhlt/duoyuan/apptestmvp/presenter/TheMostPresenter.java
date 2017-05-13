package com.sdyhlt.duoyuan.apptestmvp.presenter;

import com.sdyhlt.duoyuan.apptestmvp.bean.ShehuiBeans;
import com.sdyhlt.duoyuan.apptestmvp.model.ItheMostModel;
import com.sdyhlt.duoyuan.apptestmvp.model.TheMostModel;
import com.sdyhlt.duoyuan.apptestmvp.view.interfaces.ItheMostShowView;

import java.util.List;

/**
 * Created by jingsheng on 2016/12/25.
 */

public class TheMostPresenter {

    ItheMostShowView mShowView;

    ItheMostModel mMImodel=new TheMostModel();
    private String type;

    public TheMostPresenter(ItheMostShowView mShowView, String type) {
        this.mShowView = mShowView;
        this.type = type;
    }

    public void fetch(){
        if (mMImodel!=null){
            mMImodel.loadNews(new ItheMostModel.NewsOnListener() {
                @Override
                public void onComplete(List<ShehuiBeans.ResultBean.DataBean> newsinfo) {
                    mShowView.showNews(newsinfo);
                }
            },type);
        }

    }

    public void disdory(){
        mShowView=null;
    }
}
