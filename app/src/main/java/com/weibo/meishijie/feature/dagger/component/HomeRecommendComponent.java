package com.weibo.meishijie.feature.dagger.component;

import com.weibo.meishijie.mvp.presenter.RecommendPresenterImlp;
import com.weibo.meishijie.mvp.view.fragment.RecommendFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/29.
 * 注入RecommendFragment所需要的Model、Presenter
 */

@Component
public interface HomeRecommendComponent {
    void inject(RecommendFragment recommendFragment);
    void inject(RecommendPresenterImlp recommendPresenterImlp);
}
