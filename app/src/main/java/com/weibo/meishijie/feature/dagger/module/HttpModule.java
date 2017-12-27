package com.weibo.meishijie.feature.dagger.module;

import android.os.Environment;

import com.weibo.meishijie.mvp.model.api.MeiShiJieApiService;
import com.weibo.meishijie.mvp.model.api.MeiShiJieCacheApiService;
import com.weibo.meishijie.util.Constant;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/12/27.
 */

@Module
public class HttpModule {

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    @Singleton
    @Provides
    public MeiShiJieApiService provideMeiShiJieApiService(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build()
                .create(MeiShiJieApiService.class);
    }

    @Singleton
    @Provides
    public MeiShiJieCacheApiService provideMeiShiJieApiService() {
        File cahceDir = Environment.getDownloadCacheDirectory();
        return new RxCache.Builder()
                .persistence(cahceDir, new GsonSpeaker())
                .using(MeiShiJieCacheApiService.class);
    }

}
