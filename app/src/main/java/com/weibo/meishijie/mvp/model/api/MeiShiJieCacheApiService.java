package com.weibo.meishijie.mvp.model.api;

import com.weibo.meishijie.bean.home_recommend.HomeRecommend;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Reply;

/**
 * Created by Administrator on 2017/12/28.
 */

public interface MeiShiJieCacheApiService {
    /**
     * @return 推荐页的数据，使用rxcahe要求包装返回
     */
    @LifeCache(duration = 3,timeUnit = TimeUnit.MINUTES)
    Observable<Reply<HomeRecommend>> requestHomeRecommendData(Observable<HomeRecommend> homeRecommendObservable);
}
