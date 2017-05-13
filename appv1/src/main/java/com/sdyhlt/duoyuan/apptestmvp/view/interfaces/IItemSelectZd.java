package com.sdyhlt.duoyuan.apptestmvp.view.interfaces;

import com.sdyhlt.duoyuan.apptestmvp.bean.HuoChebean;

import java.util.List;

/**
 * Created by jingsheng on 2017/2/8.
 */

public interface IItemSelectZd {
    void showInfo(List<HuoChebean.ResultBean> info);
    void showError(int type);

}
