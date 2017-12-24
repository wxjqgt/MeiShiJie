package com.weibo.meishijie.mvp.view.fragment;


import com.weibo.meishijie.R;
import com.weibo.meishijie.base.BaseFragment;


public class DiscoveryFragment extends BaseFragment {

    public static final String TAG = DiscoveryFragment.class.getSimpleName();

    public DiscoveryFragment() {
        // Required empty public constructor
    }

    public static DiscoveryFragment newInstance() {
        DiscoveryFragment fragment = new DiscoveryFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discovery;
    }
}
