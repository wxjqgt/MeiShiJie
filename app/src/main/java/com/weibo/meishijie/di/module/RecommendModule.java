package com.weibo.meishijie.di.module;

import com.weibo.meishijie.di.scope.FragmentScope;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.model.RecommendModelImlp;
import com.weibo.meishijie.mvp.presenter.RecommendPresenterImlp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/3.
 */

@Module
public class RecommendModule {

    private RecommendContract.RecommendView recommendView;

    public RecommendModule(RecommendContract.RecommendView recommendView) {
        this.recommendView = recommendView;
    }

    @FragmentScope
    @Provides
    RecommendContract.RecommendPresenter providesRecommendPresenter(RecommendContract.RecommendModel recommendModel) {
        return new RecommendPresenterImlp(recommendModel, recommendView);
    }

    @FragmentScope
    @Provides
    RecommendContract.RecommendModel providesRecommendModel() {
        return new RecommendModelImlp();
    }
}
