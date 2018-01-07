package com.weibo.meishijie.mvp.contract;

import com.weibo.meishijie.base.BaseModel;
import com.weibo.meishijie.base.BasePresenter;
import com.weibo.meishijie.base.BaseView;
import com.weibo.meishijie.mvp.model.entities.recommend.Data;
import com.weibo.meishijie.mvp.model.entities.recommend.Recommend;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/12/29.
 */

public class RecommendContract {
    public interface RecommendPresenter extends BasePresenter {

    }

    public interface RecommendView extends BaseView {
        void showData(Data data);
    }

    public interface RecommendModel extends BaseModel {
        void load(LoadListener loadListener, boolean refresh);
    }

    public interface LoadListener {
        void loadHomeRecommendData(Observable<Recommend> homeRecommend);
    }

}
