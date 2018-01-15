package com.weibo.meishijie.mvp.contract;

import com.weibo.meishijie.mvp.base.BaseModel;
import com.weibo.meishijie.mvp.base.BasePresenter;
import com.weibo.meishijie.mvp.base.BaseView;
import com.weibo.meishijie.mvp.model.entities.recommend.Recommend;
import com.weibo.meishijie.mvp.model.entities.recommend.Sancan;

import java.util.List;

import io.reactivex.Observable;

/**
 * 管理所有在这个模块中用到的契约
 * <p>
 * Created by Administrator on 2017/12/29.
 *
 * @author 韦大帅
 */

public class RecommendContract {
    public interface RecommendPresenter extends BasePresenter {
        /**
         * 刷新数据的方法
         */
        Observable<Recommend> loadRecommendData(boolean refresh);
    }

    public interface RecommendView extends BaseView {

    }

    public interface RecommendModel extends BaseModel {
        /**
         * 用于获取资源调用
         *
         * @param refresh
         */
        Observable<Recommend> loadRecommendData(boolean refresh);
    }

    public interface LoadListener {
        /**
         * @param homeRecommend
         */
        void loadRecommendData(Observable<Recommend> homeRecommend);
    }

    /**
     * 主要用于和RecommendFragment进行交互
     */
    public interface RefreshListener {
        /**
         * 用于刷新数据
         */
        void refresh();
    }

    /**
     * 用于和推荐页里面的推荐模块Fragment通信
     * 即：RecommendRecommendFragment
     */
    public interface LoadDataListener {
        /**
         * @param sancanList
         * @return void
         */
        void loadSancanData(List<Sancan> sancanList);
    }
}
