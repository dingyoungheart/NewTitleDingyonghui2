package com.dingyonghui.newtitledingyonghui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dingyonghui.newtitledingyonghui.R;
import com.dingyonghui.newtitledingyonghui.WebViewActivity;
import com.dingyonghui.newtitledingyonghui.adapter.PullToRefreshAdapter;
import com.dingyonghui.newtitledingyonghui.bean.NewsBean;
import com.dingyonghui.newtitledingyonghui.model.CallbackNewsData;
import com.dingyonghui.newtitledingyonghui.model.HttpUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;


/**
 * Created by lx on 2017/2/12.
 */

public class Fragment_Title extends Fragment implements PullToRefreshListView.OnRefreshListener2<ListView>,CallbackNewsData<NewsBean>{

    View view;
    private PullToRefreshListView pullToRefreshListView;
    private int currentPage = 1;
    private String url;
    private PullToRefreshAdapter adapter;
    private boolean isNeedClear = false;
    private String key;
    ArrayList<NewsBean> list=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_title, null);
        key = getArguments().getString("key");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();

        url = "http://c.m.163.com/nc/article/headline/"+key+"/0-20.html";
        HttpUtils.loadDataFromServer(url,NewsBean.class,this);
    }

    private void initView() {
        pullToRefreshListView = (PullToRefreshListView)view.findViewById(R.id.pullListView);
        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("dyh",list.get(position).getUrl());
                startActivity(intent);
            }
        });
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshListView.setOnRefreshListener(this);
    }

    private void initData() {
        adapter = new PullToRefreshAdapter(getActivity());
        pullToRefreshListView.setAdapter(adapter);
//        SharedPreferences sp = getActivity().getSharedPreferences("night", getActivity().MODE_PRIVATE);
//        boolean isNight = sp.getBoolean("isNight", false);
//        if (!isNight) {
//            pullToRefreshListView.setDividerDrawable(new ColorDrawable(getResources().getColor(R.color.black_tx_color)));
//
//        }else {
//            pullToRefreshListView.setDividerDrawable(new ColorDrawable(getResources().getColor(R.color.white_tx_color)));
//        }

        pullToRefreshListView.onRefreshComplete();
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

        //下拉刷新的回调 要在这个方法里进行数据刷新

        isNeedClear=true;
//        url = ApplicationConstants.getUrl(currentPage);
        HttpUtils.loadDataFromServer(url,NewsBean.class,this);


    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        //上拉加载更多的回调

        isNeedClear = false;
//        url = ApplicationConstants.getUrl(currentPage);
        HttpUtils.loadDataFromServer(url,NewsBean.class,this);


}


    public void success(ArrayList<NewsBean> newsBeen){
        list=newsBeen;
        adapter.addData(newsBeen,false);
        adapter.notifyDataSetChanged();
//        HttpUtils.loadDataFromServer(url,NewsBean.class,this);
        pullToRefreshListView.onRefreshComplete();
    }

}
