package com.weibo.meishijie.mvp.view.fragment;


import com.weibo.meishijie.R;
import com.weibo.meishijie.base.BaseFragment;


public class TopicFragment extends BaseFragment {

    public static final String TAG = TopicFragment.class.getSimpleName();

    public TopicFragment() {
        // Required empty public constructor
    }

    public static TopicFragment newInstance() {
        TopicFragment fragment = new TopicFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_topic;
    }
}
