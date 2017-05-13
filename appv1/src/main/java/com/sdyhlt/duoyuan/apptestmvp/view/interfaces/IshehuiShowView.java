package com.sdyhlt.duoyuan.apptestmvp.view.interfaces;

import com.sdyhlt.duoyuan.apptestmvp.bean.ShehuiBeans;
import com.sdyhlt.duoyuan.apptestmvp.bean.TopNews;

import java.util.List;

/**
 * Created by jingsheng on 2016/12/25.
 */

public interface IshehuiShowView {
    void loding();

    void showNews(List<ShehuiBeans.ResultBean.DataBean> newsinfo);


}
