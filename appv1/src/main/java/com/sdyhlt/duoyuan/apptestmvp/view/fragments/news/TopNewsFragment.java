package com.sdyhlt.duoyuan.apptestmvp.view.fragments.news;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sdyhlt.duoyuan.apptestmvp.R;
import com.sdyhlt.duoyuan.apptestmvp.adapter.TopNewsAdapter;
import com.sdyhlt.duoyuan.apptestmvp.base.BaseFragment;
import com.sdyhlt.duoyuan.apptestmvp.bean.TopNews;
import com.sdyhlt.duoyuan.apptestmvp.presenter.NewsPresenter;
import com.sdyhlt.duoyuan.apptestmvp.view.interfaces.ITopNewsshowView;
import com.sdyhlt.duoyuan.apptestmvp.view.NewsInfo;

import java.util.List;

/**
 * Created by jingsheng on 2016/12/28.
 */

public class TopNewsFragment extends BaseFragment implements ITopNewsshowView {

    private ListView mListView;
    private TopNewsAdapter mAdapter;
    private SwipeRefreshLayout mRefreshLayout;

    @Override
    protected int getLayout() {
        return R.layout.listview_layout_2;

    }

    @Override
    protected void initView(View view) {
        mListView= (ListView) view.findViewById(R.id.lv_top_news_lv2);
        new NewsPresenter(this).fetch();
        mRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.refresh_lv2);

        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new NewsPresenter(TopNewsFragment.this).fetch();
                mRefreshLayout.setRefreshing(false);
//                Toast.makeText(getActivity(), "11111", Toast.LENGTH_SHORT).show();
            }
        });

        Log.e("new","new Presenter");
    }

    @Override
    public void loding() {

    }

    @Override
    public void showNews(final List<TopNews.ResultBean.DataBean> newsinfo) {
        mAdapter=new TopNewsAdapter(getActivity(),newsinfo);
        mListView.setAdapter(mAdapter);
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
