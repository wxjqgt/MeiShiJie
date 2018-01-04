package com.weibo.meishijie.mvp.model.entities.recommend;

import java.util.List;

/**
 * Created by Administrator on 2017/12/27.
 */

public class TodayRecommend {
    /**
     * title : 今日推荐
     * items : [{"cover_img":{"big":"http://s1.ig.meishij.net/p/20171225/b8fac4e596e37afc8ae22d8503624d81.jpg","width":240,"height":132},"pv_trackingURL":[],"click_trackingURL":[],"jump":"{\"type\":\"108\",\"class_name\":\"MSShangJiaContrller\",\"property\":{\"urlString\":\"https:\\/\\/www.meishij.net\\/huodong\\/zt_detail.php?id=1015\",\"goodsSource\":\"\"}}"},{"cover_img":{"big":"http://s1.ig.meishij.net/p/20171225/cc736d1b70cc69c4082bb865cfa2d654.jpg","width":240,"height":132},"pv_trackingURL":[],"click_trackingURL":[],"jump":"{\"type\":\"108\",\"class_name\":\"MSShangJiaContrller\",\"property\":{\"urlString\":\"https:\\/\\/www.meishij.net\\/huodong\\/zt_detail.php?id=1007\",\"goodsSource\":\"\"}}"},{"cover_img":{"big":"http://s1.ig.meishij.net/p/20171225/c6f96fe2fbb43868d9c89c98616f2588.jpg","width":240,"height":132},"pv_trackingURL":[],"click_trackingURL":[],"jump":"{\"type\":\"108\",\"class_name\":\"MSShangJiaContrller\",\"property\":{\"urlString\":\"https:\\/\\/m.meishij.net\\/huodong\\/zt.php?zt_id=1419\",\"goodsSource\":\"\"}}"}]
     */

    private String title;
    private List<Items> items;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

}
