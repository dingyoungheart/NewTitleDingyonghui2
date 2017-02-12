package com.dingyonghui.newtitledingyonghui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private RadioButton rd_home;
    private RadioButton rd_vedio;
    private RadioButton rd_care;
    private RadioButton rd_nologin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("log", "添加");

        rd_home = (RadioButton) findViewById(R.id.rd_home);
        rd_vedio = (RadioButton) findViewById(R.id.rd_vedio);
        rd_care = (RadioButton) findViewById(R.id.rd_care);
        rd_nologin = (RadioButton) findViewById(R.id.rd_nologin);


        initView();

    }

    //初始化布局
    public void initView() {
        Fragment_Home home = new Fragment_Home();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl, home).commit();

        rd_home.setOnClickListener(this);
        rd_home.setTextColor(Color.RED);
        rd_vedio.setOnClickListener(this);
        rd_care.setOnClickListener(this);
        rd_nologin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rd_home:
                rd_home.setSelected(true);
                rd_vedio.setSelected(false);
                rd_care.setSelected(false);
                rd_nologin.setSelected(false);
                rd_home.setTextColor(Color.RED);
                rd_vedio.setTextColor(Color.BLACK);
                rd_care.setTextColor(Color.BLACK);
                rd_nologin.setTextColor(Color.BLACK);

                Fragment_Home home = new Fragment_Home();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl, home).commit();
                break;
            case R.id.rd_vedio:
                rd_home.setSelected(false);
                rd_vedio.setSelected(true);
                rd_care.setSelected(false);
                rd_nologin.setSelected(false);
                rd_home.setTextColor(Color.BLACK);
                rd_vedio.setTextColor(Color.RED);
                rd_care.setTextColor(Color.BLACK);
                rd_nologin.setTextColor(Color.BLACK);

                Fragment_Vedio vedio = new Fragment_Vedio();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl, vedio).commit();
                break;
            case R.id.rd_care:
                rd_home.setSelected(false);
                rd_vedio.setSelected(false);
                rd_care.setSelected(true);
                rd_nologin.setSelected(false);
                rd_home.setTextColor(Color.BLACK);
                rd_vedio.setTextColor(Color.BLACK);
                rd_care.setTextColor(Color.RED);
                rd_nologin.setTextColor(Color.BLACK);

                Fragment_Care care = new Fragment_Care();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl, care).commit();
                break;
            case R.id.rd_nologin:
                rd_home.setSelected(false);
                rd_vedio.setSelected(false);
                rd_care.setSelected(false);
                rd_nologin.setSelected(true);
                rd_home.setTextColor(Color.BLACK);
                rd_vedio.setTextColor(Color.BLACK);
                rd_care.setTextColor(Color.BLACK);
                rd_nologin.setTextColor(Color.RED);

                Fragment_NoLogin noLogin = new Fragment_NoLogin();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl, noLogin).commit();
                break;

        }
    }
}
