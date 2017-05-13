package com.sdyhlt.duoyuan.apptestmvp.model;

import com.sdyhlt.duoyuan.apptestmvp.bean.TopNews;

import java.util.List;

/**
 * Created by jingsheng on 2016/12/25.
 */

public interface ItopNewsmodel {

    void loadNews(NewsOnListener listener);

    interface NewsOnListener{
        void onComplete(List<TopNews.ResultBean.DataBean> newsinfo);

    }
}
