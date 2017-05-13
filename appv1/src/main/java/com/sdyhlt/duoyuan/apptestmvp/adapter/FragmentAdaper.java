package com.sdyhlt.duoyuan.apptestmvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by jingsheng on 2016/12/30.
 */

public class FragmentAdaper extends FragmentStatePagerAdapter {

    private List<Fragment> list;
    private String titles[];

    public FragmentAdaper(FragmentManager fm,List<Fragment> list,String titles[]) {
        super(fm);
        this.list=list;
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
