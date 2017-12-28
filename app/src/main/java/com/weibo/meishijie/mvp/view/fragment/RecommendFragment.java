package com.weibo.meishijie.mvp.view.fragment;


import com.weibo.meishijie.R;
import com.weibo.meishijie.app.MeishijieApplication;
import com.weibo.meishijie.base.BaseFragment;
import com.weibo.meishijie.bean.home_recommend.HomeRecommend;
import com.weibo.meishijie.mvp.model.api.MeiShiJieApiService;
import com.weibo.meishijie.mvp.model.api.MeiShiJieCacheApiService;
import com.weibo.meishijie.util.LogUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.Reply;


public class RecommendFragment extends BaseFragment {

    public static final String TAG = RecommendFragment.class.getSimpleName();

    @Inject
    MeiShiJieCacheApiService meiShiJieCacheApiService;
    @Inject
    MeiShiJieApiService meiShiJieApiService;

    public RecommendFragment() {
        // Required empty public constructor
    }

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
    }

    @Override
    protected void init() {
        MeishijieApplication.getHttpComponent().inject(this);
    }

    @Override
    protected void loadData() {
        meiShiJieCacheApiService.requestHomeRecommendData(meiShiJieApiService.requestHomeRecommendData(), new EvictProvider(true))
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Reply<HomeRecommend>>() {
                    @Override
                    public void accept(Reply<HomeRecommend> homeRecommendReply) throws Exception {
                        HomeRecommend homeRecommend = homeRecommendReply.getData();
                        LogUtils.d(homeRecommend.getMsg());
                    }
                });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }
}
