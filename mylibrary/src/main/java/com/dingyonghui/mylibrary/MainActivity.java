package com.dingyonghui.mylibrary;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button button;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 存储夜间模式
         */
        final SharedPreferences preferences = getSharedPreferences("night", Context.MODE_PRIVATE);

        /**
         * 页面加载时获取上次保存的值
         */
        final boolean isNight = preferences.getBoolean("isNight", false);

        Log.d(getLocalClassName(),isNight+"");

        button = (Button) findViewById(R.id.change);
        listView=(ListView)findViewById(R.id.listView);
        final ChangeAdapter adapter=new ChangeAdapter(this);
        listView.setAdapter(adapter);

        /**
         * 根据保存的值，设置相应页面的模式
         */
        setNight(isNight);
        adapter.setNight(!isNight);

        /**
         * 切换夜间／日间模式
         */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isNight = preferences.getBoolean("isNight", false);
                setNight(!isNight);
                adapter.setNight(!isNight);
                isNight = isNight ? false : true;
                preferences.edit().putBoolean("isNight", isNight).commit();
                Log.d(getLocalClassName(),isNight+"");
            }
        });
    }

    /**
     * 修改按钮的夜间模式：资源在values colors.xml
     * @param isNight
     */
    private void setNight(boolean isNight) {
        if (isNight) {//夜间模式
            button.setText("夜间");
            button.setTextColor(getResources().getColor(R.color.white_tx_color));
            button.setBackgroundColor(getResources().getColor(R.color.black_btn_color));
        } else {//白天
            button.setText("日间");
            button.setTextColor(getResources().getColor(R.color.black_tx_color));
            button.setBackgroundColor(getResources().getColor(R.color.white_btn_color));
        }
    }
}
