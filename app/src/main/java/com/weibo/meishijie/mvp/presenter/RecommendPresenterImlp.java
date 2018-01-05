package com.weibo.meishijie.mvp.presenter;

import com.weibo.meishijie.feature.rx.RxUtil;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.model.entities.recommend.HomeRecommend;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

/**
 * Created by Administrator on 2017/12/29.
 */

public class RecommendPresenterImlp implements RecommendContract.RecommendPresenter, RecommendContract.LoadListener {

    private List<RecommendContract.RecommendView> recommendViewList;
    private RecommendContract.RecommendView recommendView;
    private RecommendContract.RecommendModel recommendModel;

    public RecommendPresenterImlp(RecommendContract.RecommendModel recommendModel, RecommendContract.RecommendView recommendView) {
        this.recommendView = recommendView;
        this.recommendModel = recommendModel;
        recommendViewList = new ArrayList<>(2);
        recommendViewList.add(recommendView);

    }

    @Override
    public void addObservable(RecommendContract.RecommendView recommendView) {
        recommendViewList.add(recommendView);
    }

    @Override
    public void onStart() {
        recommendModel.load(this, true);
    }

    @Override
    public void loadHomeRecommendData(Observable<HomeRecommend> result) {
        result.compose(RxUtil.io_mainO())
                .compose(recommendView.bindLifecycle())
                .zipWith(Observable.fromIterable(recommendViewList), new BiFunction<HomeRecommend, RecommendContract.RecommendView, Object>() {
                    @Override
                    public Object apply(HomeRecommend homeRecommend, RecommendContract.RecommendView recommendView) throws Exception {
                        recommendView.showData(homeRecommend.getData());
                        return null;
                    }
                }).subscribe();
    }

    @Override
    public void onDestroy() {

    }

}
