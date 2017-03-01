package com.dingyonghui.newtitledingyonghui.model;

import com.dingyonghui.newtitledingyonghui.bean.NewsBean;

import java.util.ArrayList;

/**
 * Created by lx on 2017/2/17.
 */

public interface CallbackData<T> {
    void success(T t);
    void success(ArrayList<NewsBean> newsBeen);
}
