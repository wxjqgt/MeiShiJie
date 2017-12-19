package com.weibo.meishijie.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by Administrator on 2017/12/6.
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    @LayoutRes
    protected abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        findView();
        listener();
        loadData();
    }
    protected void findView(){}
    protected void listener(){}
    protected void loadData(){}

}
