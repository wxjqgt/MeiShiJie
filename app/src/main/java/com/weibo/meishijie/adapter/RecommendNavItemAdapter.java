package com.weibo.meishijie.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.weibo.meishijie.mvp.model.entities.recommend.NavItems;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.List;

/**
 * Created by Administrator on 2018/1/4.
 */

public class RecommendNavItemAdapter extends CommonNavigatorAdapter {

    private List<NavItems> navItemsList;
    private ItemClickListener itemClickListener;

    public RecommendNavItemAdapter(List<NavItems> navItemsList,ItemClickListener itemClickListener){
        this.navItemsList = navItemsList;
        this.itemClickListener = itemClickListener;
    }
    @Override
    public int getCount() {
        return navItemsList == null ? 0 : navItemsList.size();
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
        colorTransitionPagerTitleView.setNormalColor(Color.GRAY);
        colorTransitionPagerTitleView.setSelectedColor(Color.RED);
        colorTransitionPagerTitleView.setText(navItemsList.get(index).getTitle());
        colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(view,context,index);
            }
        });
        return colorTransitionPagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        LinePagerIndicator indicator = new LinePagerIndicator(context);
        indicator.setColors(Color.RED);
        indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
        return indicator;
    }

    public interface ItemClickListener{
        void onItemClick(View view,Context context,int index);
    }

}
