package com.dingyonghui.newtitledingyonghui.model;

import java.util.ArrayList;

/**
 * Created by lx on 2017/2/17.
 */

public interface CallbackNewsData<T> {
    void success(ArrayList<T> newsBeen);
}

