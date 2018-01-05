package com.weibo.meishijie.mvp.model.api;

import com.weibo.meishijie.mvp.model.entities.recommend.Recommend;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/12/27.
 */

public interface MeiShiJieApiService {
    /**
     * @return 推荐页的数据，使用rxjava包装返回
     */
    @POST("v8/home_recommend_new.php?format=json&source=android&format=json&fc=msjandroid&lat=0.0&lon=0.0")
    Observable<Recommend> requestHomeRecommendData();
}
