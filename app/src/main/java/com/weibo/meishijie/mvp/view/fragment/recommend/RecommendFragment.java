package com.weibo.meishijie.mvp.view.fragment.recommend;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.RxLifecycleAndroid;
import com.weibo.meishijie.R;
import com.weibo.meishijie.adapter.FragmentAdapter;
import com.weibo.meishijie.adapter.RecommendNavItemAdapter;
import com.weibo.meishijie.base.BaseFragment;
import com.weibo.meishijie.di.component.DaggerRecommendComponent;
import com.weibo.meishijie.di.module.RecommendModule;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.model.entities.recommend.Data;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class RecommendFragment extends BaseFragment implements RecommendContract.RecommendView,
        RecommendNavItemAdapter.ItemClickListener,RecommendContract.RefreshListener {

    public static final String TAG = RecommendFragment.class.getSimpleName();
    @Inject
    protected RecommendContract.RecommendPresenter presenter;
    private MagicIndicator nav_indicator;
    private ViewPager nav_viewpager;
    private TextView tv_search;

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
        tv_search = find(R.id.tv_search);
    }

    @Override
    protected void loadData() {
        presenter.onStart();
    }

    @Override
    public void showData(Data data) {
        SpannableString spannableString = new SpannableString("图片 菜谱、食材");
        spannableString.setSpan(new ImageSpan(context, BitmapFactory.decodeResource(getResources(), R.mipmap.serch_hint_icon)), 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv_search.setText(spannableString);
        CommonNavigator commonNavigator = new CommonNavigator(context);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new RecommendNavItemAdapter(data.getNav_items(), this));
        nav_indicator.setNavigator(commonNavigator);

        List<Fragment> fragmentList = new ArrayList<>();
        RecommendRecommendFragment recommendRecommendFragment = RecommendRecommendFragment.newInstance();
        recommendRecommendFragment.setRefreshListener(this);
        fragmentList.add(recommendRecommendFragment);
        fragmentList.add(SmartMakeDishesFragment.newInstance());
        fragmentList.add(RecipeClassificationFragment.newInstance());
        fragmentList.add(PeopleRaidersFragment.newInstance());
        nav_viewpager.setAdapter(new FragmentAdapter(getChildFragmentManager(), fragmentList));

        ViewPagerHelper.bind(nav_indicator, nav_viewpager);

        RecommendContract.LoadDataListener loadDataListener = recommendRecommendFragment;
        loadDataListener.loadSancan(data.getSancan());

    }

    @Override
    public void onItemClick(View view, Context context, int index) {
        nav_viewpager.setCurrentItem(index);
    }

    @Override
    public void refresh() {

    }

    @Override
    public <T> LifecycleTransformer<T> bindLifecycle() {
        return RxLifecycleAndroid.bindFragment(lifecycleSubject);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        presenter = null;
    }

}
