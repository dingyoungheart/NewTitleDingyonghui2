package com.dingyonghui.newtitledingyonghui.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dingyonghui.newtitledingyonghui.R;
import com.dingyonghui.newtitledingyonghui.adapter.MyAdapter;
import com.dingyonghui.newtitledingyonghui.fragment.pindaoguanli.PindaoActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lx on 2017/2/10.
 */

public class Fragment_Home extends Fragment {

    private LinearLayout lin_home;
    private View view;
    private String[] title = {"推荐", "足球", "娱乐", "体育", "财经", "科技",
            "电影", "汽车", "笑话", "游戏", "时尚", "情感", "精选", "电台", "nba"};
    private String[] titleid = {"T1348647909107", "T1399700447917", "T1348648517839",
            "T1348649079062", "T1348648756099", "T1348649580692", "T1348648650048",
            "T1348654060988", "T1350383429665", "T1348654151579", "T1348650593803",
            "T1348650839000", "T1370583240249", "T1379038288239", "T1348649145984"};
    private ViewPager viewPager;
    private List<Fragment> list;
    private TabLayout tablayout_title;
    private SharedPreferences sp;
    private boolean isNight;
    private MyAdapter myAdapter;
    private RelativeLayout rel_top;
    private LinearLayout rl;
    private TextView tv_search;
    private ImageView iv_pindaoguanli;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();//得到数据
        sp = getActivity().getSharedPreferences("night", getActivity().MODE_PRIVATE);
        isNight = sp.getBoolean("isNight", false);
        initgetID();//得到控件

        myAdapter.setList(list);//设置适配器
        initChange();//修改值
        viewPager.setAdapter(myAdapter);
        tablayout_title.setTabMode(TabLayout.MODE_SCROLLABLE);
        tablayout_title.setupWithViewPager(viewPager);

        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_pindaoguanli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),PindaoActivity.class);
                startActivity(intent);
            }
        });

    }


    public void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            Fragment_Title fragment_title = new Fragment_Title();
            list.add(fragment_title);
            Bundle bundle = new Bundle();
            bundle.putString("key", titleid[i]);
            fragment_title.setArguments(bundle);
        }
    }

    public void initChange() {
        if (!isNight) {
            lin_home.setBackgroundColor(getResources().getColor(R.color.day_layout_bg));
            tablayout_title.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.view_night_color)));
//            tablayout_title.setSelectedTabIndicatorColor(Color.RED);
//            tablayout_title.setSelected(true);
            tablayout_title.setSelectedTabIndicatorHeight(10);
        } else {
            lin_home.setBackgroundColor(getResources().getColor(R.color.night_layout_bg));
            rel_top.setBackgroundColor(getResources().getColor(R.color.rel_top_night));
            tablayout_title.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.view_day_color)));
            tablayout_title.setSelectedTabIndicatorHeight(10);
            rl.setBackgroundColor(getResources().getColor(R.color.night_layout_bg));
            tv_search.setTextColor(getResources().getColor(R.color.white_tx_color));
//            tablayout_title.setSelected(false);
        }
    }

    public void initgetID(){
        tv_search = (TextView) view.findViewById(R.id.tv_search);
        rl = (LinearLayout) view.findViewById(R.id.rl);
        rel_top = (RelativeLayout) view.findViewById(R.id.rel_top);
        lin_home = (LinearLayout) view.findViewById(R.id.lin_home);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tablayout_title = (TabLayout) view.findViewById(R.id.tablayout_title);
        iv_pindaoguanli = (ImageView) view.findViewById(R.id.iv_pindaoguanli);
        myAdapter = new MyAdapter(getActivity().getSupportFragmentManager(), title);
    }


}
