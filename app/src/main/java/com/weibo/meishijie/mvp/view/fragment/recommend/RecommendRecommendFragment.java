package com.weibo.meishijie.mvp.view.fragment.recommend;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weibo.meishijie.R;
import com.weibo.meishijie.mvp.base.BaseFragment;
import com.weibo.meishijie.mvp.contract.RecommendContract;
import com.weibo.meishijie.mvp.model.entities.recommend.Sancan;
import com.weibo.meishijie.mvp.view.widget.ADViewpager;
import com.weibo.meishijie.util.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2018/1/4.
 * 用于显示主页内推荐页内部的推荐页内容
 *
 * @author 韦大帅
 */

public class RecommendRecommendFragment extends BaseFragment implements RecommendContract.LoadDataListener, SwipeRefreshLayout.OnRefreshListener {

    private RecommendContract.RefreshListener refreshListener;
    private SwipeRefreshLayout swipeRefreshLayout;

    /**
     * sancan每日三餐页面的View
     */
    private TextView tv_saccan;
    private ADViewpager adViewpager_sancan;

    @Override
    protected void findView() {
        swipeRefreshLayout = find(R.id.swipeRefresh_recommendrecommend);
        //sancan
        tv_saccan = find(R.id.tv_sancan);
        adViewpager_sancan = find(R.id.adViewpager_sancan);
    }

    @Override
    protected void listener() {
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void loadData(List<Sancan> sancanList) {
        adViewpager_sancan.setAdapter(new ADViewpager.CommonViewPagerAdapter<Sancan>(sancanList) {
            @Override
            public View convert(Sancan sancan, int position) {
                View view = View.inflate(context, R.layout.sancan_item, null);
                LinearLayout linearLayout = view.findViewById(R.id.hs_sancan_item);
                for (Sancan.Items item : sancan.getItems()) {
                    View itemView = View.inflate(context, R.layout.sancan_item_item, null);
                    ImageView imageView = itemView.findViewById(R.id.iv_sancan_item_item);
                    ImageLoader.load(context, item.getImg(), imageView);
                    TextView textView = itemView.findViewById(R.id.tv_sancan_item_item);
                    textView.setText(item.getTitle() + "\n" + item.getRecommend_msg());
                    linearLayout.addView(itemView);
                }
                tv_saccan.setText("每日三餐." + sancan.getTitle());
                return view;
            }
        });

    }

    @Override
    public void onRefresh() {
        refreshListener.refresh();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.recommend_recommend;
    }

    public static RecommendRecommendFragment newInstance() {
        RecommendRecommendFragment fragment = new RecommendRecommendFragment();
        return fragment;
    }

    public void setRefreshListener(RecommendContract.RefreshListener refreshListener) {
        this.refreshListener = refreshListener;
    }

}
