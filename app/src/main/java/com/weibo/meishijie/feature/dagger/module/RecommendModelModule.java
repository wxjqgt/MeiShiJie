package com.weibo.meishijie.feature.dagger.module;

import com.weibo.meishijie.feature.dagger.scope.RecommendScope;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.model.RecommendModelImlp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/1.
 */

@Module
public class RecommendModelModule {

    private RecommendContract.LoadListener loadListener;

    public RecommendModelModule(RecommendContract.LoadListener loadListener) {
        this.loadListener = loadListener;
    }

    @Provides
    @RecommendScope
    public RecommendContract.RecommendModel providesRecommendModel() {
        return new RecommendModelImlp(loadListener);
    }
}
