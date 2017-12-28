package com.weibo.meishijie.mvp.model;

import com.weibo.meishijie.app.MeishijieApplication;
import com.weibo.meishijie.base.BaseModel;
import com.weibo.meishijie.bean.home_recommend.HomeRecommend;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.model.api.MeiShiJieApiService;
import com.weibo.meishijie.mvp.model.api.MeiShiJieCacheApiService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.Reply;

/**
 * Created by Administrator on 2017/12/29.
 */

public class RecommendModelImlp implements BaseModel {

    @Inject
    MeiShiJieApiService meiShiJieApiService;
    @Inject
    MeiShiJieCacheApiService meiShiJieCacheApiService;
    private RecommendContract.RecommendPresenter recommendPresenter;

    @Inject
    public RecommendModelImlp(RecommendContract.RecommendPresenter recommendPresenter) {
        MeishijieApplication.getHttpComponent().inject(this);
        this.recommendPresenter = recommendPresenter;
    }

    @Override
    public void load() {
        meiShiJieCacheApiService.requestHomeRecommendData(meiShiJieApiService.requestHomeRecommendData(), new EvictProvider(true))
                .compose(recommendPresenter.bindToRxLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Reply<HomeRecommend>>() {
                    @Override
                    public void accept(Reply<HomeRecommend> homeRecommendReply) throws Exception {
                        HomeRecommend homeRecommend = homeRecommendReply.getData();
                        recommendPresenter.loadHomeRecommendData(homeRecommend);
                    }
                });
    }
}
