package com.weibo.meishijie.di.component;

import com.weibo.meishijie.di.module.AppModule;
import com.weibo.meishijie.feature.glide.integration.OkHttpLibraryGlideModule;
import com.weibo.meishijie.mvp.model.RecommendModelImlp;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2018/1/1.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(RecommendModelImlp recommendModelImlp);
    void inject(OkHttpLibraryGlideModule okHttpLibraryGlideModule);
}
