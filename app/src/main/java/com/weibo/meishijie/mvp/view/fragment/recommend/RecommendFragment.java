package com.weibo.meishijie.mvp.view.fragment.recommend;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.RxLifecycleAndroid;
import com.weibo.meishijie.R;
import com.weibo.meishijie.base.BaseFragment;
import com.weibo.meishijie.di.component.DaggerRecommendComponent;
import com.weibo.meishijie.di.module.RecommendModule;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.model.entities.recommend.NavItems;
import com.weibo.meishijie.mvp.model.entities.recommend.Recipes;
import com.weibo.meishijie.mvp.model.entities.recommend.Sancan;
import com.weibo.meishijie.mvp.model.entities.recommend.TodayRecommend;
import com.weibo.meishijie.mvp.model.entities.recommend.Zhuanti;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.List;

import javax.inject.Inject;

public class RecommendFragment extends BaseFragment implements RecommendContract.RecommendView {

    public static final String TAG = RecommendFragment.class.getSimpleName();
    @Inject
    protected RecommendContract.RecommendPresenter presenter;
    private MagicIndicator nav_indicator;
    private ViewPager nav_viewpager;

    public RecommendFragment() {
        DaggerRecommendComponent.builder()
                .recommendModule(new RecommendModule(this))
                .build()
                .inject(this);
    }

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
    }

    @Override
    protected void findView() {
        nav_indicator = find(R.id.nav_indicator);
        nav_viewpager = find(R.id.nav_viewpager);
    }

    @Override
    protected void loadData() {
        presenter.onStart();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void loadNavItems(List<NavItems> navItemsList) {

        CommonNavigator commonNavigator = new CommonNavigator(context);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return navItemsList == null ? 0 : navItemsList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(Color.GRAY);
                colorTransitionPagerTitleView.setSelectedColor(Color.BLACK);
                colorTransitionPagerTitleView.setText(navItemsList.get(index).getTitle());
                colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nav_viewpager.setCurrentItem(index);
                    }
                });
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                return indicator;
            }
        });
        nav_indicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(nav_indicator, nav_viewpager);
    }

    @Override
    public void loadRecipes(List<Recipes> recipesList) {

    }

    @Override
    public void loadSancan(List<Sancan> sancan) {

    }

    @Override
    public void loadTodayRecommend(TodayRecommend todayRecommend) {

    }

    @Override
    public void loadZhuanti(Zhuanti zhuanti) {

    }

    @Override
    public <T> LifecycleTransformer<T> bindLifecycle() {
        return RxLifecycleAndroid.bindFragment(lifecycleSubject);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
