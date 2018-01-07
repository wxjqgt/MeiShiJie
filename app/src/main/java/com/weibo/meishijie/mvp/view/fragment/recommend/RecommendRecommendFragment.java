package com.weibo.meishijie.mvp.view.fragment.recommend;

import com.weibo.meishijie.R;
import com.weibo.meishijie.base.BaseFragment;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.model.entities.recommend.Sancan;

import java.util.List;

/**
 * Created by Administrator on 2018/1/4.
 * 用于显示主页内推荐页内部的推荐页内容
 *
 * @author 韦大帅
 */

public class RecommendRecommendFragment extends BaseFragment implements RecommendContract.LoadDataListener {

    private RecommendContract.RefreshListener refreshListener;

    @Override
    protected int getLayoutId() {
        return R.layout.recommend_recommend;
    }

    public static RecommendRecommendFragment newInstance() {
        RecommendRecommendFragment fragment = new RecommendRecommendFragment();
        return fragment;
    }

    public void setRefreshListener(RecommendContract.RefreshListener refreshListener){
        this.refreshListener = refreshListener;
    }

    @Override
    public void loadSancan(List<Sancan> sancanList) {

    }

}
