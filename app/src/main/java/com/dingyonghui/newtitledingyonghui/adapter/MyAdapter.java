package com.dingyonghui.newtitledingyonghui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lx on 2017/2/12.
 */

public class MyAdapter extends FragmentPagerAdapter{


    private String [] title;
    private List<Fragment> list;

    public MyAdapter(FragmentManager fm ,  String []title) {
        super(fm);
        this.title=title;
    }

    public void setList(List<Fragment> list){
        this.list=list;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
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
