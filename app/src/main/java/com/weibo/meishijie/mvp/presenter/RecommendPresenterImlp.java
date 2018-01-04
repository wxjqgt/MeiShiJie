package com.weibo.meishijie.mvp.presenter;

import com.weibo.meishijie.feature.rx.RxUtil;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.model.entities.recommend.Data;
import com.weibo.meishijie.mvp.model.entities.recommend.HomeRecommend;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

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
    public void loadHomeRecommendData(Observable<HomeRecommend> result) {
        result.compose(recommendView.bindLifecycle())
                .compose(RxUtil.io_mainO())
                .subscribe(new Consumer<HomeRecommend>() {
                    @Override
                    public void accept(HomeRecommend homeRecommend) throws Exception {
                        Data data = homeRecommend.getData();
                        recommendView.loadNavItems(data.getNav_items());
                        recommendView.loadRecipes(data.getRecipes());
                        recommendView.loadSancan(data.getSancan());
                        recommendView.loadTodayRecommend(data.getToday_recommend());
                        recommendView.loadZhuanti(data.getZhuanti());
                    }
                });
    }

    @Override
    public void onDestroy() {

    }

}
