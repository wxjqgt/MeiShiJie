package com.weibo.meishijie.mvp.base;

import android.arch.lifecycle.LifecycleObserver;

/**
 * Created by Administrator on 2017/12/29.
 */

public interface BasePresenter extends LifecycleObserver{
    void onStart();
    void onDestroy();
}
