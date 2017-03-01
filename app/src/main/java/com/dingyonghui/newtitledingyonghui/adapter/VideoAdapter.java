package com.dingyonghui.newtitledingyonghui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lx on 2017/2/23.
 */

public class VideoAdapter extends FragmentPagerAdapter {

    private List<Fragment> list=new ArrayList<>();
    private String [] videotitle;

    public VideoAdapter(FragmentManager fm, String[] videotitle) {
        super(fm);
        this.videotitle = videotitle;
    }

    public void setList(List<Fragment> list){
        this.list=list;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return videotitle[position];
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
