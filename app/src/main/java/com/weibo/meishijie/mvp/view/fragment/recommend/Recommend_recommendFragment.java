package com.weibo.meishijie.mvp.view.fragment.recommend;

import com.weibo.meishijie.R;
import com.weibo.meishijie.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/4.
 * 用于显示主页内推荐页内部的推荐页内容
 *
 * @author 韦大帅
 */

public class Recommend_recommendFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.recommend_recommend;
    }

    public static Recommend_recommendFragment newInstance() {
        Recommend_recommendFragment fragment = new Recommend_recommendFragment();
        return fragment;
    }
}
