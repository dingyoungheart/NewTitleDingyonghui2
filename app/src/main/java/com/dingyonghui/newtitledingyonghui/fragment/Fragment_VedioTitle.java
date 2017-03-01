package com.dingyonghui.newtitledingyonghui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dingyonghui.newtitledingyonghui.R;
import com.dingyonghui.newtitledingyonghui.adapter.VideoListViewAdapter;
import com.dingyonghui.newtitledingyonghui.bean.VideoBean;
import com.dingyonghui.newtitledingyonghui.model.CallbackNewsData;
import com.dingyonghui.newtitledingyonghui.model.HttpUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by lx on 2017/2/23.
 */

public class Fragment_VedioTitle extends Fragment implements PullToRefreshListView.OnRefreshListener2<ListView>, CallbackNewsData<VideoBean> {

    private View view;
    private PullToRefreshListView video_lv;
    private VideoListViewAdapter adapter;
    private String url;
    private String video;
    private ArrayList<VideoBean> list = new ArrayList<>();
    private boolean isNeedClear = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.video_title, null);
        video = getArguments().getString("video");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        url = "http://c.3g.163.com/nc/video/list/"+video+"/n/10-10.html";

        initView();
        initData();

        HttpUtils.loadDataFromServer(url, VideoBean.class, this);
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    private void initView() {
        video_lv = (PullToRefreshListView) view.findViewById(R.id.video_lv);
        video_lv.setMode(PullToRefreshBase.Mode.BOTH);
        video_lv.setOnRefreshListener(this);
    }

    private void initData() {
        adapter = new VideoListViewAdapter(getActivity());
        video_lv.setAdapter(adapter);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
        isNeedClear = true;
        HttpUtils.loadDataFromServer(url, VideoBean.class, this);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        isNeedClear = false;
        HttpUtils.loadDataFromServer(url, VideoBean.class, this);
    }

    @Override
    public void success(ArrayList<VideoBean> newsBeen) {
        list = newsBeen;
        adapter.AddData(list, isNeedClear);
        adapter.notifyDataSetChanged();
        video_lv.onRefreshComplete();
    }
}
