package com.weibo.meishijie.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * Created by Administrator on 2017/12/7.
 */

public abstract class BaseFragment extends RxFragment {

    private View view;

    public BaseFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), container, false);
        findView();
        listener();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getUserVisibleHint() && view != null) {
            loadData();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && view != null) {
            loadData();
        }
    }

    private void init() {
    }

    protected void findView() {
    }

    protected void listener() {
    }

    protected void loadData() {
    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected <T extends View> T find(int id) {
        return (T) view.findViewById(id);
    }

}
