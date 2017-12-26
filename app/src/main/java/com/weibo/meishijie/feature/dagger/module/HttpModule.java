package com.weibo.meishijie.feature.dagger.module;

import com.weibo.meishijie.util.Constant;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
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
    public OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder()
                .build();
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build();
    }
}
