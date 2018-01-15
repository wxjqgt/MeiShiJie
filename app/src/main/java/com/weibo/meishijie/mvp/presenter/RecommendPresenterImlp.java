package com.weibo.meishijie.mvp.presenter;

import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.model.entities.recommend.Recommend;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/12/29.
 */

public class RecommendPresenterImlp implements RecommendContract.RecommendPresenter{

    private RecommendContract.RecommendModel recommendModel;

    public RecommendPresenterImlp(RecommendContract.RecommendModel recommendModel) {
        this.recommendModel = recommendModel;
    }

    @Override
    public void onStart() {

    }

    @Override
    public Observable<Recommend> loadRecommendData(boolean refresh) {
        return recommendModel.loadRecommendData(refresh);
    }

    @Override
    public void onDestroy() {
        recommendModel = null;
    }

}
