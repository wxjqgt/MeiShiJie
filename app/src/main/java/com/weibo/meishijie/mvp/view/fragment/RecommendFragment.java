package com.weibo.meishijie.mvp.view.fragment;


import com.weibo.meishijie.R;
import com.weibo.meishijie.base.BaseFragment;
import com.weibo.meishijie.bean.home_recommend.HomeRecommend;
import com.weibo.meishijie.feature.dagger.component.DaggerHttpComponent;
import com.weibo.meishijie.mvp.model.api.HomeRecommendService;
import com.weibo.meishijie.util.LogUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class RecommendFragment extends BaseFragment {

    public static final String TAG = RecommendFragment.class.getSimpleName();

    @Inject
    Retrofit retrofit;

    public RecommendFragment() {
        // Required empty public constructor
    }

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
    }

    @Override
    protected void init() {
        DaggerHttpComponent.create().inject(this);
    }

    @Override
    protected void loadData() {
        HomeRecommendService homeRecommendService = retrofit.create(HomeRecommendService.class);
        homeRecommendService.request()
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeRecommend>() {
                    @Override
                    public void accept(HomeRecommend homeRecommend) throws Exception {
                        LogUtils.d(homeRecommend.getMsg());
                    }
                });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }
}
