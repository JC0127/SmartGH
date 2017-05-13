package com.sdyhlt.duoyuan.apptestmvp.model;

import com.sdyhlt.duoyuan.apptestmvp.bean.ShehuiBeans;
import com.sdyhlt.duoyuan.apptestmvp.bean.TopNews;

import java.util.List;

/**
 * Created by jingsheng on 2016/12/25.
 */

public interface ItheMostModel {

    void loadNews(NewsOnListener listener,String type);

    interface NewsOnListener{
        void onComplete(List<ShehuiBeans.ResultBean.DataBean> newsinfo);

    }
}
