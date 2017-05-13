package com.sdyhlt.duoyuan.apptestmvp.base;

import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * Created by jingsheng on 2016/12/28.
 */

public abstract class BasePresenter<T> {

    protected WeakReference<T> mViewRef;

    public void attachView(T view){
        mViewRef=new WeakReference<T>(view);
    }

    public void detachView(){
        if (mViewRef !=null){
            mViewRef.clear();
            mViewRef=null;
        }

        Log.d("detachView","detachView is down!");
    }

    public T getView(){
        return mViewRef.get();
    }
}
