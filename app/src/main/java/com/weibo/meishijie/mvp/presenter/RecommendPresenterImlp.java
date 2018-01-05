package com.weibo.meishijie.mvp.presenter;

import com.weibo.meishijie.feature.rx.RxUtil;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.model.entities.recommend.Recommend;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

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
    public void loadHomeRecommendData(Observable<Recommend> result) {
        result.compose(RxUtil.io_mainO())
                .compose(recommendView.bindLifecycle())
                .subscribe(recommend -> {
                    for (RecommendContract.RecommendView recommendView : recommendViewList) {
                        recommendView.showData(recommend.getData());
                    }
                });
    }

    @Override
    public void onDestroy() {

    }

}
