package com.weibo.meishijie.app;

import android.app.Application;
import android.content.Context;

import com.weibo.meishijie.di.component.AppComponent;
import com.weibo.meishijie.di.component.DaggerAppComponent;
import com.weibo.meishijie.di.module.AppModule;

import org.jetbrains.annotations.NotNull;

/**
 * Created by 美貌与智慧并重的男子 on 2016/7/30.
 */

public class MeishijieApplication extends Application {

    private AppComponent appComponent;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static MeishijieApplication getContext() {
        return (MeishijieApplication) context;
    }

    @NotNull
    public AppComponent getAppComponent() {
        return appComponent;
    }

}
