package com.sdyhlt.duoyuan.apptestmvp.view.fragments.news;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sdyhlt.duoyuan.apptestmvp.R;
import com.sdyhlt.duoyuan.apptestmvp.adapter.TheMostAdapter;
import com.sdyhlt.duoyuan.apptestmvp.base.BaseFragment;
import com.sdyhlt.duoyuan.apptestmvp.bean.ShehuiBeans;
import com.sdyhlt.duoyuan.apptestmvp.presenter.TheMostPresenter;
import com.sdyhlt.duoyuan.apptestmvp.view.NewsInfo;
import com.sdyhlt.duoyuan.apptestmvp.view.interfaces.ItheMostShowView;

import java.util.List;

/**
 * Created by jingsheng on 2016/12/30.
 */

public class CaiJingFragment extends BaseFragment implements ItheMostShowView {
    private ListView mListView;
    private SwipeRefreshLayout refreshLayout;
    @Override
    protected int getLayout() {
        return R.layout.listview_layout_2;
    }

    @Override
    protected void initView(View view) {
        mListView= (ListView) view.findViewById(R.id.lv_top_news_lv2);
        refreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.refresh_lv2);

        new TheMostPresenter(CaiJingFragment.this,"caijing").fetch();
        refreshLayout.setColorSchemeColors(Color.RED,Color.GREEN);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new TheMostPresenter(CaiJingFragment.this,"caijing").fetch();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefreshing(false);
                    }
                },1000);
            }

        });


    }

    @Override
    public void loding() {

    }

    @Override
    public void showNews(final List<ShehuiBeans.ResultBean.DataBean> newsinfo) {
        mListView.setAdapter(new TheMostAdapter(getActivity(),newsinfo));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),NewsInfo.class);
                intent.putExtra("url",newsinfo.get(position).getUrl());
                startActivity(intent);
            }
        });

    }
}
