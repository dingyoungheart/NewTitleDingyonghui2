package com.dingyonghui.newtitledingyonghui.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dingyonghui.newtitledingyonghui.R;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONObject;

/**
 * Created by lx on 2017/2/10.
 */

public class Fragment_NoLogin extends Fragment {
    public static String mAppid="1105924500";
    private Tencent mtencent;
    LinearLayout lin1;
    SharedPreferences sp;
    TextView night;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    TextView tvN;
    TextView sc;
    TextView ls;
    View view1;
    View view2;
    View view3;
    View view;
    private LinearLayout lin_home;
    private LinearLayout lin_vedio;
    private LinearLayout lin_care;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;
    private boolean isNight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_nologin, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mtencent=Tencent.createInstance(mAppid,getActivity());

        initGetID();//得到控件
        initSetData();//设置夜间模式保存的值

        setNight(isNight);
        /**
         * 切换夜间／日间模式
         */
        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isNight = sp.getBoolean("isNight", false);
                setNight(!isNight);
//                adapter.setNight(!isNight);
                isNight = isNight ? false : true;
                sp.edit().putBoolean("isNight", isNight).commit();

            }
        });

        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtencent.login(getActivity(),"all",loginListener);
            }
        });

    }

    /**
     * 修改按钮的夜间模式：资源在values colors.xml
     *
     * @param isNight
     */
    public void setNight(boolean isNight) {
        if (isNight) {//夜间模式
            night.setText("日间");
            night.setTextColor(getResources().getColor(R.color.white_tx_color));
            night.setBackgroundColor(getResources().getColor(R.color.night_layout_bg));
            view1.setBackgroundColor(getResources().getColor(R.color.view_night_color));
            view2.setBackgroundColor(getResources().getColor(R.color.view_night_color));
            view3.setBackgroundColor(getResources().getColor(R.color.view_night_color));
            sc.setTextColor(getResources().getColor(R.color.white_tx_color));
            ls.setTextColor(getResources().getColor(R.color.white_tx_color));
            tv1.setTextColor(getResources().getColor(R.color.white_tx_color));
            tv2.setTextColor(getResources().getColor(R.color.white_tx_color));
            tv3.setTextColor(getResources().getColor(R.color.white_tx_color));
            tv4.setTextColor(getResources().getColor(R.color.white_tx_color));
            tv5.setTextColor(getResources().getColor(R.color.white_tx_color));
            tv6.setTextColor(getResources().getColor(R.color.white_tx_color));
            tvN.setTextColor(getResources().getColor(R.color.white_tx_color));
            iv1.setBackgroundResource(R.drawable.cellphoneicon_login_profile_press);
            iv2.setBackgroundResource(R.drawable.weixinicon_login_profile_press);
            iv3.setBackgroundResource(R.drawable.qqicon_login_profile_press);
            night.setSelected(false);
            lin1.setBackgroundColor(getResources().getColor(R.color.night_layout_bg));

        } else {//白天
            night.setText("夜间");
            night.setTextColor(getResources().getColor(R.color.black_tx_color));
            night.setBackgroundColor(getResources().getColor(R.color.day_layout_bg));
            view1.setBackgroundColor(getResources().getColor(R.color.view_day_color));
            view2.setBackgroundColor(getResources().getColor(R.color.view_day_color));
            view3.setBackgroundColor(getResources().getColor(R.color.view_day_color));
            sc.setTextColor(getResources().getColor(R.color.black_tx_color));
            ls.setTextColor(getResources().getColor(R.color.black_tx_color));
            tv1.setTextColor(getResources().getColor(R.color.black_tx_color));
            tv2.setTextColor(getResources().getColor(R.color.black_tx_color));
            tv3.setTextColor(getResources().getColor(R.color.black_tx_color));
            tv4.setTextColor(getResources().getColor(R.color.black_tx_color));
            tv5.setTextColor(getResources().getColor(R.color.black_tx_color));
            tv6.setTextColor(getResources().getColor(R.color.black_tx_color));
            tvN.setTextColor(getResources().getColor(R.color.black_tx_color));
            iv1.setBackgroundResource(R.drawable.cellphoneicon_login_profile);
            iv2.setBackgroundResource(R.drawable.weixin_allshare_normal);
            iv3.setBackgroundResource(R.drawable.qqicon_login_profile);
            lin1.setBackgroundColor(getResources().getColor(R.color.day_layout_bg));
            night.setSelected(true);
        }
    }
    /*
    得到控件
     */
    public void initGetID() {
        night = (TextView) view.findViewById(R.id.night);
        tv1 = (TextView) view.findViewById(R.id.tv1);
        tv2 = (TextView) view.findViewById(R.id.tv2);
        tv3 = (TextView) view.findViewById(R.id.tv3);
        tv4 = (TextView) view.findViewById(R.id.tv4);
        tv5 = (TextView) view.findViewById(R.id.tv5);
        tv6 = (TextView) view.findViewById(R.id.tv6);
        tvN = (TextView) view.findViewById(R.id.tvN);
        sc = (TextView) view.findViewById(R.id.sc);
        ls = (TextView) view.findViewById(R.id.ls);
        view1 = (View) view.findViewById(R.id.View1);
        view2 = (View) view.findViewById(R.id.View2);
        view3 = (View) view.findViewById(R.id.View3);
        iv1 = (ImageView) view.findViewById(R.id.iv1);
        iv2 = (ImageView) view.findViewById(R.id.iv2);
        iv3 = (ImageView) view.findViewById(R.id.iv3);
        iv4 = (ImageView) view.findViewById(R.id.iv4);
        lin1 = (LinearLayout) view.findViewById(R.id.lin1);
//        lin11=(LinearLayout) view.findViewById(R.id.ll);
        lin_home = (LinearLayout) view.findViewById(R.id.lin_home);
        lin_vedio = (LinearLayout) view.findViewById(R.id.lin_vedio);
        lin_care = (LinearLayout) view.findViewById(R.id.lin_care);
    }
    public void initSetData(){
        sp = getActivity().getSharedPreferences("night", Context.MODE_PRIVATE);
        /**
         * 页面加载时获取上次保存的值
         */
        isNight = sp.getBoolean("isNight", false);
        /**
         * 存储夜间模式
         */
        /**
         * 根据保存的值，设置相应页面的模式
         */
    }

    IUiListener loginListener = new BaseUiListener() {
        @Override
        protected void doComplete(JSONObject values) {
            Log.d("SDKQQAgentPref", "AuthorSwitch_SDK:" + SystemClock.elapsedRealtime());
        }
    };
    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {

            doComplete((JSONObject)response);
        }

        protected void doComplete(JSONObject values) {
            Log.i("miaojx",values.toString());
        }

        @Override
        public void onError(UiError e) {
            Log.i("miaojx",e.toString());
        }

        @Override
        public void onCancel() {

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Tencent.onActivityResultData(requestCode,resultCode,data,loginListener);

    }


}
