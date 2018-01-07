package com.weibo.meishijie.mvp.contract;

import com.weibo.meishijie.base.BaseModel;
import com.weibo.meishijie.base.BasePresenter;
import com.weibo.meishijie.base.BaseView;
import com.weibo.meishijie.mvp.model.entities.recommend.Data;
import com.weibo.meishijie.mvp.model.entities.recommend.Recommend;
import com.weibo.meishijie.mvp.model.entities.recommend.Sancan;

import java.util.List;

import io.reactivex.Observable;

/**
 * 管理所有在这个模块中用到的契约
 * @author 韦大帅
 * Created by Administrator on 2017/12/29.
 */

public class RecommendContract {
    public interface RecommendPresenter extends BasePresenter {

    }

    public interface RecommendView extends BaseView {
        /**
         * 用于显示数据
         *
         * @param data
         */
        void showData(Data data);
    }

    public interface RecommendModel extends BaseModel {
        /**
         * 用于获取资源调用
         *
         * @param loadListener 传入的回掉接口
         * @param refresh
         */
        void load(LoadListener loadListener, boolean refresh);
    }

    public interface LoadListener {
        /**
         * @param homeRecommend
         */
        void loadHomeRecommendData(Observable<Recommend> homeRecommend);
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
        void loadSancan(List<Sancan> sancanList);
    }
}
