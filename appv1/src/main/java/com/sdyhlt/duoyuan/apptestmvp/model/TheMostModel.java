package com.sdyhlt.duoyuan.apptestmvp.model;

import com.google.gson.Gson;
import com.sdyhlt.duoyuan.apptestmvp.bean.IHttpUrls;
import com.sdyhlt.duoyuan.apptestmvp.bean.ShehuiBeans;
import com.sdyhlt.duoyuan.apptestmvp.bean.TopNews;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by jingsheng on 2016/12/25.
 */

public class TheMostModel implements ItheMostModel {


    private List<ShehuiBeans.ResultBean.DataBean> datas;


    @Override
    public void loadNews(final NewsOnListener listener,String type) {
        datas=new ArrayList<ShehuiBeans.ResultBean.DataBean>();

        final List<TopNews.ResultBean.DataBean> deta=new ArrayList<>();

        OkHttpUtils.get().url(IHttpUrls.NEWS_HEAD+type+IHttpUrls.NEWS_END).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                ShehuiBeans news=new Gson().fromJson(response,ShehuiBeans.class);
                for (ShehuiBeans.ResultBean.DataBean bean:news.getResult().getData()){

                    datas.add(bean);
                }
                listener.onComplete(datas);

            }
        });


    }


}
