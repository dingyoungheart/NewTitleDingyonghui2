package com.dingyonghui.newtitledingyonghui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by lx on 2017/2/10.
 */

public class Fragment_NoLogin extends Fragment{

    LinearLayout lin1;
//    LinearLayout lin11;
    SharedPreferences sp;
    TextView night;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    TextView sc;
    TextView ls;
    View view1;
    View view2;
    View view3;

    View view;
    private LinearLayout lin_home;
    private LinearLayout lin_vedio;
    private LinearLayout lin_care;

    public Fragment_NoLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_nologin, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        night=(TextView)view.findViewById(R.id.night);
        tv1=(TextView)view.findViewById(R.id.tv1);
        tv2=(TextView)view.findViewById(R.id.tv2);
        tv3=(TextView)view.findViewById(R.id.tv3);
        tv4=(TextView)view.findViewById(R.id.tv4);
        tv5=(TextView)view.findViewById(R.id.tv5);
        tv6=(TextView)view.findViewById(R.id.tv6);
        sc=(TextView)view.findViewById(R.id.sc);
        ls=(TextView)view.findViewById(R.id.ls);
        view1=(View) view.findViewById(R.id.View1);
        view2=(View) view.findViewById(R.id.View2);
        view3=(View) view.findViewById(R.id.View3);

        lin1=(LinearLayout) view.findViewById(R.id.lin1);
//        lin11=(LinearLayout) view.findViewById(R.id.ll);
        lin_home = (LinearLayout) view.findViewById(R.id.lin_home);
        lin_vedio = (LinearLayout) view.findViewById(R.id.lin_vedio);
        lin_care = (LinearLayout) view.findViewById(R.id.lin_care);


        sp = getActivity().getSharedPreferences("night", Context.MODE_PRIVATE);
        /**
         * 页面加载时获取上次保存的值
         */
        final boolean isNight = sp.getBoolean("isNight", false);
        /**
         * 存储夜间模式
         */
        /**
         * 根据保存的值，设置相应页面的模式
         */
        setNight(isNight);

        // Log.d(getLocalClassName(),isNight+"");
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

//                Log.d(getLocalClassName(),isNight+"");
            }
        });


    }
    /**
     * 修改按钮的夜间模式：资源在values colors.xml
     * @param isNight
     */
    private void setNight(boolean isNight) {
        if (isNight) {//夜间模式
            night.setText("夜间");
            night.setTextColor(getResources().getColor(R.color.white_tx_color));
            night.setBackgroundColor(getResources().getColor(R.color.night_layout_bg));
//            lin11.setBackgroundColor(getResources().getColor(R.color.night_layout_bg));
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
            lin_home.setBackgroundColor(getResources().getColor(R.color.night_layout_bg));
            lin_vedio.setBackgroundColor(getResources().getColor(R.color.night_layout_bg));
            lin_care.setBackgroundColor(getResources().getColor(R.color.night_layout_bg));
            night.setSelected(false);
            lin1.setBackgroundColor(getResources().getColor(R.color.night_layout_bg));

        } else {//白天
            night.setText("日间");
//            night.setBackground(getResources().getDrawable(R.drawable.ibig_typebar_details));
            night.setTextColor(getResources().getColor(R.color.black_tx_color));
            night.setBackgroundColor(getResources().getColor(R.color.day_layout_bg));
//            lin11.setBackgroundColor(getResources().getColor(R.color.day_layout_bg));
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
            lin1.setBackgroundColor(getResources().getColor(R.color.day_layout_bg));
            lin_home.setBackgroundColor(getResources().getColor(R.color.day_layout_bg));
            lin_vedio.setBackgroundColor(getResources().getColor(R.color.day_layout_bg));
            lin_care.setBackgroundColor(getResources().getColor(R.color.day_layout_bg));
            night.setSelected(true);

        }
    }


}
