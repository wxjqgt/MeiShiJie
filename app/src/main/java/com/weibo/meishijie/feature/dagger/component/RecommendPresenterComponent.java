package com.weibo.meishijie.feature.dagger.component;

import com.weibo.meishijie.feature.dagger.module.RecommendPresenterModule;
import com.weibo.meishijie.feature.dagger.scope.RecommendScope;
import com.weibo.meishijie.mvp.view.fragment.RecommendFragment;

import dagger.Component;

/**
 * Created by Administrator on 2018/1/1.
 */

@RecommendScope
@Component(modules = RecommendPresenterModule.class)
public interface RecommendPresenterComponent {
    void inject(RecommendFragment recommendFragment);
}
