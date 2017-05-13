package com.sdyhlt.duoyuan.apptestmvp.view.interfaces;

import com.sdyhlt.duoyuan.apptestmvp.bean.TopNews;

import java.util.List;

/**
 * Created by jingsheng on 2016/12/25.
 */

public interface ITopNewsshowView {
    void loding();

    void showNews(List<TopNews.ResultBean.DataBean > newsinfo);


}
