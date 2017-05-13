package com.sdyhlt.duoyuan.apptestmvp.model;

import android.util.Log;

import com.google.gson.Gson;
import com.sdyhlt.duoyuan.apptestmvp.bean.HuoChebean;
import com.sdyhlt.duoyuan.apptestmvp.bean.IHttpUrls;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;

/**
 * Created by jingsheng on 2017/2/9.
 */

public class TrainZDmodel implements ItrainZDmodel {
    private List<HuoChebean.ResultBean> list;

    @Override
    public void loadeInfo(final infoListener listener, String startAdd, String endAdd) {
        OkHttpUtils.get().url(IHttpUrls.TRAIN_ZD_HEAAD+"&start="+startAdd+"&end="+endAdd).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                listener.onError(0);
            }

            @Override
            public void onResponse(String response, int id) {
                list=new ArrayList<HuoChebean.ResultBean>();

//                Log.e("ssss",response);
                if (response!=null){
                    try {
                        JSONObject object=new JSONObject(response);
                        String retCode = object.optString("retCode");
                        if (retCode.equals("23201")){
                            listener.onError(1);
                            return;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    HuoChebean huoChebean=new Gson().fromJson(response,HuoChebean.class);

                    for (HuoChebean.ResultBean bean:huoChebean.getResult()){
//                        Log.d("aaaaa",bean.toString());
                        list.add(bean);
                    }
                    listener.onComplete(list);

                }
            }
        });
    }

    @Override
    public void loadeInfo(final infoListener listener, String cheCi) {
        OkHttpUtils.get().url(IHttpUrls.TRAIN_CHECI_HEAAD+"&trainno="+cheCi).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                listener.onError(0);
            }

            @Override
            public void onResponse(String response, int id) {
                list=new ArrayList<HuoChebean.ResultBean>();

//                Log.e("ssss",response);
                if (response!=null){
                    try {
                        JSONObject object=new JSONObject(response);
                        String retCode = object.optString("retCode");
                        if (retCode.equals("23201")){
                            listener.onError(1);
                            return;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    HuoChebean huoChebean=new Gson().fromJson(response,HuoChebean.class);

                    for (HuoChebean.ResultBean bean:huoChebean.getResult()){
//                        Log.d("aaaaa",bean.toString());
                        list.add(bean);
                    }
                    listener.onComplete(list);

                }
            }
        });
    }
}
