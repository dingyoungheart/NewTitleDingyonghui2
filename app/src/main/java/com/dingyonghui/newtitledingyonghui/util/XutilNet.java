package com.dingyonghui.newtitledingyonghui.util;

import android.util.Log;

import com.dingyonghui.newtitledingyonghui.bean.JokeBean;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by lx on 2017/2/15.
 */

public class XutilNet {

    public static  void loadDataFromServer(int currentPage,final CallbackData callbackData,String url){
        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {


            @Override
            public void onSuccess(String result) {
                callbackData.success(result);
                Gson gson = new Gson();
                JokeBean jokeBean = gson.fromJson(result, JokeBean.class);
                if (jokeBean.getError_code() == 0) {
                    List<JokeBean.ResultBean.DataBean> data = jokeBean.getResult().getData();


                }
                Log.e("myMessage","current Thread "+Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }

    public interface CallbackData {
        void success(String result);
    }

}
