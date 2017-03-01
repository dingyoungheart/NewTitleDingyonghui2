package com.dingyonghui.newtitledingyonghui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dingyonghui.newtitledingyonghui.R;
import com.dingyonghui.newtitledingyonghui.adapter.VideoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lx on 2017/2/10.
 */

public class Fragment_Vedio extends Fragment {
    private View view;
    private TabLayout tablayout_video;

    private String [] videotitle={"热点视频","娱乐视频","搞笑视频","精品视频"};
    private String [] videotitleID={"V9LG4B3A0","V9LG4CHOR","V9LG4E6VR","00850FRB"};
    private ViewPager vp_video;
    private List<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_vedio,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tablayout_video = (TabLayout) view.findViewById(R.id.tablayout_video);
        vp_video = (ViewPager) view.findViewById(R.id.vp_video);

        initData();

        VideoAdapter adapter=new VideoAdapter(getActivity().getSupportFragmentManager(),videotitle);
        vp_video.setAdapter(adapter);
        adapter.setList(list);

        vp_video.setAdapter(adapter);
        tablayout_video.setTabMode(TabLayout.MODE_SCROLLABLE);
        tablayout_video.setupWithViewPager(vp_video);

    }

    private void initData() {
        list=new ArrayList<>();
        for (int i=0;i<videotitle.length;i++){
            Fragment_VedioTitle fragment_vedioTitle = new Fragment_VedioTitle();
            list.add(fragment_vedioTitle);
            Bundle bundle=new Bundle();
            bundle.putString("video",videotitleID[i]);
            fragment_vedioTitle.setArguments(bundle);
        }

    }
}
