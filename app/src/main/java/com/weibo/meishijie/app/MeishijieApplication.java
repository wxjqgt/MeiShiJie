package com.weibo.meishijie.app;

import android.app.Application;
import android.content.Context;

import com.weibo.meishijie.feature.dagger.component.DaggerHttpComponent;
import com.weibo.meishijie.feature.dagger.component.HttpComponent;

/**
 * Created by 美貌与智慧并重的男子 on 2016/7/30.
 */

public class MeishijieApplication extends Application {

    private static Context context;
    private static HttpComponent httpComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        httpComponent = DaggerHttpComponent.create();
    }

    public static Context getContext(){
        return context;
    }

    public static HttpComponent getHttpComponent(){
        return httpComponent;
    }

}
