package com.weibo.meishijie.feature.dagger.component;

import com.weibo.meishijie.feature.dagger.module.RecommendModelModule;
import com.weibo.meishijie.feature.dagger.scope.RecommendScope;
import com.weibo.meishijie.mvp.presenter.RecommendPresenterImlp;

import dagger.Component;

/**
 * Created by Administrator on 2018/1/1.
 */

@RecommendScope
@Component(modules = RecommendModelModule.class)
public interface RecommendModelComponent {
    void inject(RecommendPresenterImlp recommendPresenterImlp);
}
