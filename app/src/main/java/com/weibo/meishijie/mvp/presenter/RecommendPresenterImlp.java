package com.weibo.meishijie.mvp.presenter;

import com.weibo.meishijie.feature.rx.RxUtil;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.model.entities.home_recommend.Data;
import com.weibo.meishijie.mvp.model.entities.home_recommend.HomeRecommend;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.rx_cache2.Reply;

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
    public void loadHomeRecommendData(Observable<Reply<HomeRecommend>> result) {
        result.compose(recommendView.bindLifecycle())
                .compose(RxUtil.io_mainO())
                .subscribe(new Consumer<Reply<HomeRecommend>>() {
                    @Override
                    public void accept(Reply<HomeRecommend> homeRecommend) throws Exception {
                        Data data = homeRecommend.getData().getData();
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
