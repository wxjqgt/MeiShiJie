package com.weibo.meishijie.mvp.view.fragment.recommend;

import com.weibo.meishijie.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/4.
 * 用于显示主页内推荐页内部的菜谱分类页内容
 *
 * @author 韦大帅
 */

public class RecipeClassificationFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return 0;
    }

    public static RecipeClassificationFragment newInstance() {
        RecipeClassificationFragment fragment = new RecipeClassificationFragment();
        return fragment;
    }
}
