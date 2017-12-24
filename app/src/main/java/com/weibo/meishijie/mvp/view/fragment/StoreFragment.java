package com.weibo.meishijie.mvp.view.fragment;


import com.weibo.meishijie.R;
import com.weibo.meishijie.base.BaseFragment;


public class StoreFragment extends BaseFragment {

    public static final String TAG = StoreFragment.class.getSimpleName();

    public StoreFragment() {
        // Required empty public constructor
    }

    public static StoreFragment newInstance() {
        StoreFragment fragment = new StoreFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_store;
    }
}
