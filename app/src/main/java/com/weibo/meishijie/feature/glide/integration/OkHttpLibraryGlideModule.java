package com.weibo.meishijie.feature.glide.integration;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.weibo.meishijie.feature.dagger.component.DaggerHttpComponent;

import java.io.InputStream;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/**
 * Registers OkHttp related classes via Glide's annotation processor.
 * <p>
 * <p>For Applications that depend on this library and include an
 * {@link AppGlideModule} and Glide's annotation processor, this class
 * will be automatically included.
 */
@GlideModule
public final class OkHttpLibraryGlideModule extends AppGlideModule {

    @Inject
    OkHttpClient okHttpClient;

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide,
                                   @NonNull Registry registry) {
        DaggerHttpComponent.create().inject(this);
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(okHttpClient));
    }
}
