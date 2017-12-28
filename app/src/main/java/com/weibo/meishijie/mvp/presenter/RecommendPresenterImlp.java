package com.weibo.meishijie.mvp.presenter;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.weibo.meishijie.base.BaseModel;
import com.weibo.meishijie.bean.home_recommend.Data;
import com.weibo.meishijie.bean.home_recommend.HomeRecommend;
import com.weibo.meishijie.mvp.contract.RecommendContract;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/12/29.
 */

public class RecommendPresenterImlp implements RecommendContract.RecommendPresenter {

    @Inject
    BaseModel recommendmodel;
    private RecommendContract.RecommendView recommendView;

    @Inject
    public RecommendPresenterImlp(RecommendContract.RecommendView recommendView){
        this.recommendView = recommendView;
    }

    @Override
    public void onStart() {
        recommendmodel.load();
    }

    @Override
    public void loadHomeRecommendData(HomeRecommend homeRecommend) {
        Data data = homeRecommend.getData();
        recommendView.loadNavItems(data.getNav_items());
        recommendView.loadRecipes(data.getRecipes());
        recommendView.loadSancan(data.getSancan());
        recommendView.loadTodayRecommend(data.getToday_recommend());
        recommendView.loadZhuanti(data.getZhuanti());
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public LifecycleTransformer providesLifecycleTransformer() {
        return recommendView.bindToRxLifecycle();
    }
}
