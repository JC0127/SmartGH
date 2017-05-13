package com.sdyhlt.duoyuan.apptestmvp.view.interfaces;

import com.sdyhlt.duoyuan.apptestmvp.bean.ShehuiBeans;

import java.util.List;

/**
 * Created by jingsheng on 2016/12/25.
 */

public interface ItheMostShowView {
    void loding();

    void showNews(List<ShehuiBeans.ResultBean.DataBean> newsinfo);


}
