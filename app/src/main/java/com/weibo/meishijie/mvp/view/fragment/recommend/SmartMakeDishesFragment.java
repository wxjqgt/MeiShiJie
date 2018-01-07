package com.weibo.meishijie.mvp.view.fragment.recommend;

import com.weibo.meishijie.R;
import com.weibo.meishijie.mvp.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/4.
 * 用于显示主页内推荐页内部的智能组菜页内容
 *
 * @author 韦大帅
 */

public class SmartMakeDishesFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.smart_make_dishes;
    }

    public static SmartMakeDishesFragment newInstance() {
        SmartMakeDishesFragment fragment = new SmartMakeDishesFragment();
        return fragment;
    }
}
