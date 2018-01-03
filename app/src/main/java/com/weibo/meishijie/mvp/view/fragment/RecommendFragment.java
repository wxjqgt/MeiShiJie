package com.weibo.meishijie.mvp.view.fragment;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.weibo.meishijie.R;
import com.weibo.meishijie.base.BaseFragment;
import com.weibo.meishijie.bean.home_recommend.NavItems;
import com.weibo.meishijie.bean.home_recommend.Recipes;
import com.weibo.meishijie.bean.home_recommend.Sancan;
import com.weibo.meishijie.bean.home_recommend.TodayRecommend;
import com.weibo.meishijie.bean.home_recommend.Zhuanti;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.util.LogUtils;

import net.lucode.hackware.magicindicator.MagicIndicator;

import java.util.List;

import javax.inject.Inject;

public class RecommendFragment extends BaseFragment implements RecommendContract.RecommendView {

    public static final String TAG = RecommendFragment.class.getSimpleName();

    @Inject
    RecommendContract.RecommendPresenter recommendPresenter;
    private MagicIndicator nav_indicator;

    public RecommendFragment() {

    }

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
    }

    @Override
    protected void findView() {
        nav_indicator = find(R.id.nav_indicator);
    }

    @Override
    protected void loadData() {
       /* CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return mTitleDataList == null ? 0 : mTitleDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(Color.GRAY);
                colorTransitionPagerTitleView.setSelectedColor(Color.BLACK);
                colorTransitionPagerTitleView.setText(mTitleDataList.get(index));
                colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mViewPager.setCurrentItem(index);
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
        magicIndicator.setNavigator(commonNavigator);*/

        recommendPresenter.onStart();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void loadNavItems(List<NavItems> navItemsList) {
        LogUtils.d(navItemsList);
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
    public <T> LifecycleTransformer<T> bindToRxLifecycle() {
        return bindToLifecycle();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        recommendPresenter.onDestroy();
    }
}
