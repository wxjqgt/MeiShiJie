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

import com.weibo.meishijie.R;
import com.weibo.meishijie.di.component.DaggerRecommendComponent;
import com.weibo.meishijie.mvp.base.BaseFragment;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.model.entities.recommend.Data;
import com.weibo.meishijie.mvp.view.adapter.FragmentAdapter;
import com.weibo.meishijie.mvp.view.adapter.RecommendNavItemAdapter;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * create on 2018/01/15
 *
 * @author 韦大帅
 */
public class RecommendFragment extends BaseFragment implements RecommendContract.RecommendView,
        RecommendNavItemAdapter.ItemClickListener, RecommendContract.RefreshListener {

    public static final String TAG = RecommendFragment.class.getSimpleName();
    @Inject
    protected RecommendContract.RecommendPresenter presenter;
    private MagicIndicator nav_indicator;
    private ViewPager nav_viewpager;
    /**
     * sancan
     */
    private TextView tv_search;
    private CommonNavigator commonNavigator;
    private RecommendRecommendFragment recommendRecommendFragment;
    private List<Fragment> fragmentList;

    public RecommendFragment() {
        DaggerRecommendComponent.create().inject(this);
    }

    @Override
    protected void findView() {
        nav_indicator = find(R.id.nav_indicator);
        nav_viewpager = find(R.id.nav_viewpager);
        tv_search = find(R.id.tv_search);
    }

    @Override
    protected void initView() {
        commonNavigator = new CommonNavigator(context);
        commonNavigator.setAdjustMode(true);

        fragmentList = new ArrayList<>();
        recommendRecommendFragment = RecommendRecommendFragment.newInstance();
        fragmentList.add(recommendRecommendFragment);
        fragmentList.add(SmartMakeDishesFragment.newInstance());
        fragmentList.add(RecipeClassificationFragment.newInstance());
        fragmentList.add(PeopleRaidersFragment.newInstance());
    }

    @Override
    protected void listener() {
        recommendRecommendFragment.setRefreshListener(this);
    }

    @Override
    protected void loadData() {
        presenter.onStart();
        refresh();
    }

    public void loadRecommendData(Data data) {
        SpannableString spannableString = new SpannableString("图片 " + data.getSearch_hint());
        ImageSpan imageSpan = new ImageSpan(context, BitmapFactory.decodeResource(getResources(), R.mipmap.serch_hint_icon));
        spannableString.setSpan(imageSpan, 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv_search.setText(spannableString);
        commonNavigator.setAdapter(new RecommendNavItemAdapter(data.getNav_items(), this));
        RecommendContract.LoadDataListener loadDataListener = recommendRecommendFragment;
        loadDataListener.loadSancanData(data.getSancan());
    }

    @Override
    public void onResume() {
        super.onResume();
        nav_indicator.setNavigator(commonNavigator);
        nav_viewpager.setAdapter(new FragmentAdapter(getChildFragmentManager(), fragmentList));
        ViewPagerHelper.bind(nav_indicator, nav_viewpager);
    }

    @Override
    public void onItemClick(View view, Context context, int index) {
        nav_viewpager.setCurrentItem(index);
    }

    @Override
    public void refresh() {
        presenter.loadRecommendData(true)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(recommend -> loadRecommendData(recommend.getData()));
    }

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
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
