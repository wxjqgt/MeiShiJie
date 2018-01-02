package com.weibo.meishijie.mvp.view.fragment;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.weibo.meishijie.R;
import com.weibo.meishijie.base.BaseFragment;
import com.weibo.meishijie.bean.home_recommend.NavItems;
import com.weibo.meishijie.bean.home_recommend.Recipes;
import com.weibo.meishijie.bean.home_recommend.Sancan;
import com.weibo.meishijie.bean.home_recommend.TodayRecommend;
import com.weibo.meishijie.bean.home_recommend.Zhuanti;
import com.weibo.meishijie.feature.dagger.component.DaggerRecommendPresenterComponent;
import com.weibo.meishijie.feature.dagger.module.RecommendPresenterModule;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.util.LogUtils;

import java.util.List;

import javax.inject.Inject;

public class RecommendFragment extends BaseFragment implements RecommendContract.RecommendView {

    public static final String TAG = RecommendFragment.class.getSimpleName();

    @Inject
    RecommendContract.RecommendPresenter recommendPresenter;

    public RecommendFragment() {
        DaggerRecommendPresenterComponent.builder()
                .recommendPresenterModule(new RecommendPresenterModule(this))
                .build()
                .inject(this);
    }

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
    }

    @Override
    protected void loadData() {
        recommendPresenter.onStart();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void loadNavItems(List<NavItems> navItemsList) {
        LogUtils.d(navItemsList);
    }

    @Override
    public void loadRecipes(List<Recipes> recipesList) {

    }

    @Override
    public void loadSancan(List<Sancan> sancan) {

    }

    @Override
    public void loadTodayRecommend(TodayRecommend todayRecommend) {

    }

    @Override
    public void loadZhuanti(Zhuanti zhuanti) {

    }

    @Override
    public <T> LifecycleTransformer<T> bindToRxLifecycle() {
        return bindToLifecycle();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        recommendPresenter.onDestroy();
    }
}
