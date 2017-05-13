package com.sdyhlt.duoyuan.apptestmvp.view.fragments;

import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.sdyhlt.duoyuan.apptestmvp.R;
import com.sdyhlt.duoyuan.apptestmvp.adapter.WeixinAdapter;
import com.sdyhlt.duoyuan.apptestmvp.base.BaseFragment;
import com.sdyhlt.duoyuan.apptestmvp.bean.WeixinBeans;
import com.sdyhlt.duoyuan.apptestmvp.presenter.WeixinPresenter;
import com.sdyhlt.duoyuan.apptestmvp.view.interfaces.IweixinShowView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jingsheng on 2016/12/28.
 */

public class WeixinNewsFragment extends BaseFragment implements IweixinShowView{
    private ListView listView;
    private WeixinAdapter mAdapter;
    private int page=1;
    private SwipeRefreshLayout mRefreshLayout;
    private List<List<WeixinBeans.ResultBean.ListBean>> mList=new ArrayList<>();
    private List<List<WeixinBeans.ResultBean.ListBean>> mTempList=new ArrayList<>();
    @Override
    protected int getLayout() {
        return R.layout.weixin_listview;
    }

    @Override
    protected void initView(View view) {
        listView= (ListView) view.findViewById(R.id.listBeen);
        mRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.weixin_refresh);
        new WeixinPresenter(this).fetch(page);
        page++;
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new WeixinPresenter(WeixinNewsFragment.this).fetch(page);

                page++;
            }
        });
    }

    @Override
    public void showView(List<WeixinBeans.ResultBean.ListBean> listBeen) {
        List<WeixinBeans.ResultBean.ListBean> listBeens;
        int size = listBeen.size()/5;
//        Log.e("size",size+"");


        for (int i=0;i<size;i++){
            listBeens=new ArrayList<>();
            for (int j=0;j<5;j++){
               listBeens.add(listBeen.get(i * 5 + j));
//                Log.e("listBeen.get(i * 5 + j)",listBeen.get(i * 5 + j).toString());
            }
            mList.add(listBeens);
//            listBeens.clear();
        }

        mTempList.clear();
        for (int i=0;i<mList.size();i++){
            mTempList.add(mList.get(i));
        }
        Collections.reverse(mTempList);//倒序集合里面的内容
        mAdapter=new WeixinAdapter(mTempList,getActivity());
//        Collections.reverse(mList);

//        mAdapter.notifyDataSetChanged();

        listView.setAdapter(mAdapter);

//        listView.setSelection(1);
        listView.setSelectionFromTop(4,100);
//        listView.setStackFromBottom(true);
        mRefreshLayout.setRefreshing(false);
}

    @Override
    public void showError() {
        mRefreshLayout.setRefreshing(false);
        Toast.makeText(getActivity(), "请检查网络！", Toast.LENGTH_SHORT).show();
    }
}
