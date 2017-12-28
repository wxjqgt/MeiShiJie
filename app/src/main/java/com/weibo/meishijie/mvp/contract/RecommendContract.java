package com.weibo.meishijie.mvp.contract;

import com.weibo.meishijie.base.BasePresenter;
import com.weibo.meishijie.base.BaseView;
import com.weibo.meishijie.bean.home_recommend.HomeRecommend;
import com.weibo.meishijie.bean.home_recommend.NavItems;
import com.weibo.meishijie.bean.home_recommend.Recipes;
import com.weibo.meishijie.bean.home_recommend.Sancan;
import com.weibo.meishijie.bean.home_recommend.TodayRecommend;
import com.weibo.meishijie.bean.home_recommend.Zhuanti;

import java.util.List;

/**
 * Created by Administrator on 2017/12/29.
 */

public class RecommendContract {
    public interface RecommendPresenter extends BasePresenter{
        void loadHomeRecommendData(HomeRecommend homeRecommend);
    }
    public interface RecommendView extends BaseView{
        void loadNavItems(List<NavItems> navItemsList);
        void loadRecipes(List<Recipes> recipesList);
        void loadSancan(List<Sancan> sancan);
        void loadTodayRecommend(TodayRecommend todayRecommend);
        void loadZhuanti(Zhuanti zhuanti);
    }
}
