package com.weibo.meishijie.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by 美貌与智慧并重的男子 on 2016/7/30.
 */

public class MeishijieApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext(){
        return context;
    }

}
