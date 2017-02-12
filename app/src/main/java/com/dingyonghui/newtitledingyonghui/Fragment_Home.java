package com.dingyonghui.newtitledingyonghui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.dingyonghui.newtitledingyonghui.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lx on 2017/2/10.
 */

public class Fragment_Home extends Fragment {

    private View view;
    private String[] title = {"推荐", "热点", "阳光", "体育", "北京", "社会", "娱乐", "财经"};

    private ViewPager viewPager;
    private List<Fragment> list;
    private TabLayout tablayout_title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, null);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tablayout_title = (TabLayout) view.findViewById(R.id.tablayout_title);
        MyAdapter myAdapter = new MyAdapter(getActivity().getSupportFragmentManager(), title);
        myAdapter.setList(list);

        viewPager.setAdapter(myAdapter);
        tablayout_title.setTabMode(TabLayout.MODE_SCROLLABLE);
        tablayout_title.setupWithViewPager(viewPager);



    }

    public void initData() {

        list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            Fragment_Title fragment_title=new Fragment_Title();
            list.add(fragment_title);

        }
    }
}
