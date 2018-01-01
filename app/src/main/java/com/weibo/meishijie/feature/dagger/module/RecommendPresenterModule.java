package com.weibo.meishijie.feature.dagger.module;

import com.weibo.meishijie.feature.dagger.scope.RecommendScope;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.presenter.RecommendPresenterImlp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/1.
 */

@Module
public class RecommendPresenterModule {

    private RecommendContract.RecommendView recommendView;

    public RecommendPresenterModule(RecommendContract.RecommendView recommendView) {
        this.recommendView = recommendView;
    }

    @Provides
    @RecommendScope
    public RecommendContract.RecommendPresenter providesRecommendPresenter() {
        return new RecommendPresenterImlp(recommendView);
    }
}
