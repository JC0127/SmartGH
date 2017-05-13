package com.sdyhlt.duoyuan.apptestmvp.bean;

/**
 * Created by jingsheng on 2016/12/25.
 */

public interface IHttpUrls {
    String NEWS_HEAD="http://v.juhe.cn/toutiao/index?type=";
    String NEWS_END="&key=920ff5cf6e12c4cd10d6c48a41a3f944";
    String WEIXIN_NEWS="http://v.juhe.cn/weixin/query?pno=";
    String WEIXIN_FOOT="&ps=20&dtype=json&key=d0ffbf2f9bb696db4a8d0d1bddbbf66c";
    String TRAIN_ZD_HEAAD="http://apicloud.mob.com/train/tickets/queryByStationToStation?key=1b1deb8d8a42a";
    String TRAIN_CHECI_HEAAD="http://apicloud.mob.com/train/tickets/queryByTrainNo?key=1b1deb8d8a42a";
    String WEATHER_HEAD="http://apicloud.mob.com/v1/weather/query?key=1b1deb8d8a42a&city=";
}
