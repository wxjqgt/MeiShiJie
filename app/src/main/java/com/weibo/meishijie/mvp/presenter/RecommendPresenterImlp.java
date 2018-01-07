package com.weibo.meishijie.mvp.presenter;

import com.weibo.meishijie.feature.rx.RxUtil;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.model.entities.recommend.Recommend;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/12/29.
 */

public class RecommendPresenterImlp implements RecommendContract.RecommendPresenter, RecommendContract.LoadListener {

    private RecommendContract.RecommendView recommendView;
    private RecommendContract.RecommendModel recommendModel;

    public RecommendPresenterImlp(RecommendContract.RecommendModel recommendModel, RecommendContract.RecommendView recommendView) {
        this.recommendView = recommendView;
        this.recommendModel = recommendModel;
    }

    @Override
    public void onStart() {
        recommendModel.load(this, true);
    }

    @Override
    public void loadHomeRecommendData(Observable<Recommend> result) {
        result.compose(RxUtil.io_mainO())
                .compose(recommendView.bindLifecycle())
                .subscribe(recommend -> {
                        recommendView.showData(recommend.getData());
                });
    }

    @Override
    public void onDestroy() {
        recommendView = null;
        recommendModel = null;
    }

}
