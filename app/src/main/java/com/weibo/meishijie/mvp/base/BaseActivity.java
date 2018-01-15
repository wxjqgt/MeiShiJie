package com.weibo.meishijie.mvp.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.weibo.meishijie.util.AutoUtils;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Administrator on 2017/12/6.
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    @NotNull
    @LayoutRes
    protected abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        AutoUtils.setSize(this,true,1080,1920);
        findView();
        listener();
        loadData();
    }
    protected void findView(){}
    protected void listener(){}
    protected void loadData(){}

}
