package com.weibo.meishijie.util;

import android.content.Context;
import android.widget.ImageView;

import com.weibo.meishijie.feature.glide.integration.GlideApp;

/**
 * Created by Administrator on 2016/5/6.
 */
public final class ImageLoader {
    public static void load(Context context, String url, ImageView imageView) {
        LogUtils.e(url);
        GlideApp.with(context).load(url).into(imageView);
    }
}
