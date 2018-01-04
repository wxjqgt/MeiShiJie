package com.weibo.meishijie.mvp.model.api;

import com.weibo.meishijie.mvp.model.entities.recommend.HomeRecommend;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.Encrypt;
import io.rx_cache2.EncryptKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Migration;
import io.rx_cache2.ProviderKey;
import io.rx_cache2.SchemeMigration;

/**
 * Created by Administrator on 2017/12/28.
 */

@SchemeMigration({
        @Migration(version = 1, evictClasses = {HomeRecommend.class})
})
@EncryptKey("meishijie_cache_provides")
public interface MeiShiJieCacheApiService {
    /**
     * @return 推荐页的数据，使用rxcahe要求包装返回
     */
    @ProviderKey("request_home_recommend_data")
    @Encrypt
    @LifeCache(duration = 3, timeUnit = TimeUnit.MINUTES)
    Observable<HomeRecommend> requestHomeRecommendData(Observable<HomeRecommend> homeRecommendObservable, EvictProvider evictProvider);
}
