package com.weibo.meishijie.app;

import android.app.Application;
import android.content.Context;

import com.weibo.meishijie.feature.dagger.component.AppComponent;
import com.weibo.meishijie.feature.dagger.component.DaggerAppComponent;

/**
 * Created by 美貌与智慧并重的男子 on 2016/7/30.
 */

public class MeishijieApplication extends Application {

    private static AppComponent appComponent;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        appComponent = DaggerAppComponent.create();
    }

    public static Context getContext(){
        return context;
    }
    public static AppComponent getAppComponent(){
        return appComponent;
    }

}
