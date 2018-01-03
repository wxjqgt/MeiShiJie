package com.weibo.meishijie.di.component;

import com.weibo.meishijie.di.module.AppModule;
import com.weibo.meishijie.feature.glide.integration.OkHttpLibraryGlideModule;
import com.weibo.meishijie.mvp.model.RecommendModelImlp;
import com.weibo.meishijie.mvp.model.api.MeiShiJieApiService;
import com.weibo.meishijie.mvp.model.api.MeiShiJieCacheApiService;

import javax.inject.Singleton;

import dagger.Component;
import io.rx_cache2.internal.RxCache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2018/1/1.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    OkHttpClient providesOkHttpClient();
    RxCache providesRxCache();
    Retrofit providesRetrofit();
    MeiShiJieCacheApiService providesCacheApi();
    MeiShiJieApiService providesApi();
    void inject(RecommendModelImlp recommendModelImlp);
    void inject(OkHttpLibraryGlideModule okHttpLibraryGlideModule);
}
