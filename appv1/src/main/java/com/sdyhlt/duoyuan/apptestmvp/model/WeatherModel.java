package com.sdyhlt.duoyuan.apptestmvp.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sdyhlt.duoyuan.apptestmvp.bean.IHttpUrls;
import com.sdyhlt.duoyuan.apptestmvp.bean.WeatherBeans;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.VideoFragment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by 王俊杰 on 2017/5/12.
 */

public class WeatherModel implements IweatherModel {
    private List<WeatherBeans.ResultBean> list=new ArrayList<>();
    @Override
    public void loadInfo(final InfoOnListner onListner, String pages, final Context c) {
        Log.e("ipip",pages);
        OkHttpUtils.get().url(IHttpUrls.WEATHER_HEAD+pages+"&province=山东").build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                onListner.error();
            }

            @Override
            public void onResponse(String response, int id) {
                Log.e("ssssss",response.length()+"");
                if (response.length()<50){
                    Toast.makeText(c, "地址IP无法查询天气！", Toast.LENGTH_SHORT).show();
                    onListner.error();
                    return;
                }
                if (response!=null){
                    WeatherBeans beans=new Gson().fromJson(response,WeatherBeans.class);
                    for (WeatherBeans.ResultBean futureBean:beans.getResult()){
                        list.add(futureBean);
                    }
                    onListner.onComplete(list);
                }

            }
        });

    }
}
