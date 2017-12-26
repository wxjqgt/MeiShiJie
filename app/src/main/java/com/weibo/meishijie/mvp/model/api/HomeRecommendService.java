package com.weibo.meishijie.mvp.model.api;

import com.weibo.meishijie.bean.home_recommend.HomeRecommend;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/12/27.
 */

public interface HomeRecommendService {
    @POST("v8/home_recommend_new.php?format=json&source=android&format=json&fc=msjandroid&lat=0.0&lon=0.0")
    Observable<HomeRecommend> request();
}
