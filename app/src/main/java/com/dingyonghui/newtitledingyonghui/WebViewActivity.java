package com.dingyonghui.newtitledingyonghui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.umeng.message.PushAgent;

public class WebViewActivity extends AppCompatActivity {

    private WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        wb = (WebView) findViewById(R.id.wb);

        wb.loadUrl(getIntent().getStringExtra("dyh"));

        PushAgent.getInstance(this).onAppStart();

    }
}
