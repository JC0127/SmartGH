package com.sdyhlt.duoyuan.apptestmvp.view.fragments;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.sdyhlt.duoyuan.apptestmvp.R;
import com.sdyhlt.duoyuan.apptestmvp.adapter.FragmentAdaper;
import com.sdyhlt.duoyuan.apptestmvp.base.BaseFragment;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.news.CaiJingFragment;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.news.GuoJiFragment;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.news.GuoneiFragment;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.news.JunshiFragment;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.news.KeJiFragment;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.news.ShehuiFragment;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.news.ShishangFragment;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.news.TiyuFragment;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.news.TopNewsFragment;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.news.YuLeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jingsheng on 2016/12/30.
 */

public class HomeFragment extends BaseFragment {

    private FragmentAdaper mFragmentAdaper;
    private List<Fragment> mFragmentList;
    private TabLayout tabLayout;
    private ViewPager mVp;
    private String titles[]={"头条","社会","国内","国际","娱乐","体育","军事","科技","财经","时尚"};

    @Override
    protected int getLayout() {
        return R.layout.news_viewpager_layout;
    }

    @Override
    protected void initView(View view) {
        tabLayout= (TabLayout) view.findViewById(R.id.tablayout_news);
        mVp= (ViewPager) view.findViewById(R.id.vp_news);
        setVp();


    }

    private void setVp() {
        mFragmentList=new ArrayList<>();
        mFragmentList.add(new TopNewsFragment());
        mFragmentList.add(new ShehuiFragment());
        mFragmentList.add(new GuoneiFragment());
        mFragmentList.add(new GuoJiFragment());
        mFragmentList.add(new YuLeFragment());
        mFragmentList.add(new TiyuFragment());
        mFragmentList.add(new JunshiFragment());
        mFragmentList.add(new KeJiFragment());
        mFragmentList.add(new CaiJingFragment());
        mFragmentList.add(new ShishangFragment());

        tabLayout.setupWithViewPager(mVp);
        tabLayout.setTabTextColors(Color.rgb(134,197,255),Color.WHITE);
        tabLayout.setSelectedTabIndicatorHeight(4);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                for (int i=0;i<tabLayout.getChildCount();i++){
                    if (tabLayout.getTabAt(i)==tab){
                        mVp.setCurrentItem(i);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mFragmentAdaper=new FragmentAdaper(getChildFragmentManager(),mFragmentList,titles);
        mVp.setAdapter(mFragmentAdaper);


    }
}
