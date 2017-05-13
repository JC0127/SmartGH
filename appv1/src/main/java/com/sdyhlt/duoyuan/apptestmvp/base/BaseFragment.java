package com.sdyhlt.duoyuan.apptestmvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jingsheng on 2016/12/28.
 */

public abstract class BaseFragment extends Fragment {

    private Context context;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initOnCreate();
        Log.e("new","new Presenter");
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("new","new onAttach");

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(getLayout(),container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("new","new onViewCreated");
        inits(view);
    }

    public void initOnCreate(){

    }

    protected void inits(View view){
        initView(view);
    }

    protected abstract int getLayout();

    protected abstract void initView(View view);

}
