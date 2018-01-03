package com.weibo.meishijie.di.component;

import com.weibo.meishijie.di.module.RecommendModule;
import com.weibo.meishijie.di.scope.FragmentScope;
import com.weibo.meishijie.mvp.view.fragment.RecommendFragment;

import dagger.Component;

/**
 * Created by Administrator on 2018/1/3.
 */

@FragmentScope
@Component(modules = RecommendModule.class)
public interface RecommendComponent {
    void inject(RecommendFragment recommendFragment);
}
