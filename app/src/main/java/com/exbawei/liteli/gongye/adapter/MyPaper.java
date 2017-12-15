package com.exbawei.liteli.gongye.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by li te li on 2017/12/13.
 */

public class MyPaper extends FragmentPagerAdapter {
    FragmentManager fragmentManager;
    List<Fragment> list;
    public MyPaper(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
