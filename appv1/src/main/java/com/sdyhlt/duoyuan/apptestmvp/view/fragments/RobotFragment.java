package com.sdyhlt.duoyuan.apptestmvp.view.fragments;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sdyhlt.duoyuan.apptestmvp.R;
import com.sdyhlt.duoyuan.apptestmvp.adapter.FragmentAdaper;
import com.sdyhlt.duoyuan.apptestmvp.base.BaseFragment;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.huoche.CheciFrangment;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.huoche.ZhanDainFrangment;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.news.ShehuiFragment;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.news.TopNewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jingsheng on 2016/12/28.
 */

public class RobotFragment extends BaseFragment{
    private FragmentAdaper mFragmentAdaper;
    private List<Fragment> mFragmentList;
    private TabLayout tabLayout;
    private LinearLayout l01;
    private Button bt01,bt02,bt03;
    private ViewPager mVp;
    private String titles[]={"站点查询","车次查询"};
    @Override
    protected int getLayout() {
        return R.layout.huoche_layout;
    }

    @Override
    protected void initView(View view) {
        tabLayout= (TabLayout) view.findViewById(R.id.tablayout_huoche);
        mVp= (ViewPager) view.findViewById(R.id.vp_huoche);
        l01= (LinearLayout) view.findViewById(R.id.ll_01);
        l01.setVisibility(View.GONE);
        bt01= (Button) view.findViewById(R.id.bt_001);
        bt02= (Button) view.findViewById(R.id.bt_002);
        bt03= (Button) view.findViewById(R.id.bt_003);
        bt01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "已开启智能管理！", Toast.LENGTH_SHORT).show();
            }
        });
        bt02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "已启动！", Toast.LENGTH_SHORT).show();

            }
        });
        bt03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "已启动风机！", Toast.LENGTH_SHORT).show();

            }
        });
        setVp();
    }

    private void setVp() {
        mFragmentList=new ArrayList<>();
        mFragmentList.add(new ZhanDainFrangment());
        mFragmentList.add(new CheciFrangment());


        tabLayout.setupWithViewPager(mVp);
        tabLayout.setTabTextColors(Color.rgb(134,197,255),Color.WHITE);
        tabLayout.setSelectedTabIndicatorHeight(6);
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
