package com.weibo.meishijie.mvp.view.fragment;


import com.weibo.meishijie.R;
import com.weibo.meishijie.base.BaseFragment;


public class RecommendFragment extends BaseFragment {

    public static final String TAG = RecommendFragment.class.getSimpleName();

    public RecommendFragment() {
        // Required empty public constructor
    }

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }
}
