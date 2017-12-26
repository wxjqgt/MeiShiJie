package com.weibo.meishijie.feature.dagger.component;

import com.weibo.meishijie.feature.dagger.module.HttpModule;
import com.weibo.meishijie.feature.glide.integration.OkHttpLibraryGlideModule;
import com.weibo.meishijie.mvp.view.fragment.RecommendFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/27.
 */

@Singleton
@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(RecommendFragment recommendFragment);
    void inject(OkHttpLibraryGlideModule okHttpLibraryGlideModule);
}
