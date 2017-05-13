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
 * Created by jingsheng on 2016/12/30.
 */

public class ShehuiModel implements IshehuiNewsmodel {

    private List<ShehuiBeans.ResultBean.DataBean> datas;
    @Override
    public void loadNews(final NewsOnListener listener) {
        OkHttpUtils.get().url(IHttpUrls.NEWS_HEAD+"shehui"+IHttpUrls.NEWS_END).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                if (response!=null){
                    datas=new ArrayList<ShehuiBeans.ResultBean.DataBean>();
                    ShehuiBeans topNews=new Gson().fromJson(response,ShehuiBeans.class);
                    for (ShehuiBeans.ResultBean.DataBean info:topNews.getResult().getData()){
                        datas.add(info);
                    }
                }
                listener.onComplete(datas);

            }
        });

    }
}
