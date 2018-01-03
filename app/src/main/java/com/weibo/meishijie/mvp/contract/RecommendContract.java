package com.weibo.meishijie.mvp.contract;

import com.weibo.meishijie.base.BaseModel;
import com.weibo.meishijie.base.BasePresenter;
import com.weibo.meishijie.base.BaseView;
import com.weibo.meishijie.mvp.model.entities.home_recommend.HomeRecommend;
import com.weibo.meishijie.mvp.model.entities.home_recommend.NavItems;
import com.weibo.meishijie.mvp.model.entities.home_recommend.Recipes;
import com.weibo.meishijie.mvp.model.entities.home_recommend.Sancan;
import com.weibo.meishijie.mvp.model.entities.home_recommend.TodayRecommend;
import com.weibo.meishijie.mvp.model.entities.home_recommend.Zhuanti;

import java.util.List;

import io.reactivex.Observable;
import io.rx_cache2.Reply;

/**
 * Created by Administrator on 2017/12/29.
 */

public class RecommendContract {
    public interface RecommendPresenter extends BasePresenter {

    }

    public interface RecommendView extends BaseView {
        void loadNavItems(List<NavItems> navItemsList);

        void loadRecipes(List<Recipes> recipesList);

        void loadSancan(List<Sancan> sancan);

        void loadTodayRecommend(TodayRecommend todayRecommend);

        void loadZhuanti(Zhuanti zhuanti);
    }

    public interface RecommendModel extends BaseModel {
        void load(LoadListener loadListener, boolean refresh);
    }

    public interface LoadListener {
        void loadHomeRecommendData(Observable<Reply<HomeRecommend>> homeRecommend);
    }
}
