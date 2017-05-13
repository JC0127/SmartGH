package com.sdyhlt.duoyuan.apptestmvp.model;

import android.util.Log;

import com.google.gson.Gson;
import com.sdyhlt.duoyuan.apptestmvp.bean.IHttpUrls;
import com.sdyhlt.duoyuan.apptestmvp.bean.WeixinBeans;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by jingsheng on 2017/1/3.
 */

public class WeixinModule implements IweixinModule {
    private List<WeixinBeans.ResultBean.ListBean> list=new ArrayList<>();
    @Override
    public void loadInfo(final InfoOnListner onListner, int pages) {
//        Log.e("url",IHttpUrls.WEIXIN_NEWS+pages+IHttpUrls.WEIXIN_FOOT);
        OkHttpUtils.get().url(IHttpUrls.WEIXIN_NEWS+pages+IHttpUrls.WEIXIN_FOOT).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
//                Log.e("error",id+"");
                onListner.error();

            }

            @Override
            public void onResponse(String response, int id) {
//                list=new ArrayList<WeixinBeans.ResultBean.ListBean>();

                if (response!=null){
                    WeixinBeans weixinBeans=new Gson().fromJson(response,WeixinBeans.class);
                    for (WeixinBeans.ResultBean.ListBean listBean:weixinBeans.getResult().getList()){
                        list.add(listBean);
                    }
                    onListner.onComplete(list);
                }
            }
        });
    }
}
