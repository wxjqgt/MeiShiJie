package com.weibo.meishijie.mvp.model.entities.home_recommend;

import java.util.List;

/**
 * Created by Administrator on 2017/12/27.
 */

public class Zhuanti {
    /**
     * title : 新鲜专题
     * items : [{"cover_img":{"big":"http://s1.ig.meishij.net/p/20171225/53a4adbcecc738cce8f16977da7a514d.jpg","width":"710","height":"310"},"pv_trackingURL":[],"click_trackingURL":[],"jump":"{\"type\":\"103\",\"class_name\":\"MSJWebAdvViewController\",\"property\":{\"urlString\":\"https:\\/\\/www.meishij.net\\/huodong\\/zt_detail.php?id=1015\",\"goodsSource\":\"4,1015\"}}"},{"cover_img":{"big":"http://s1.ig.meishij.net/p/20171225/dd69d8b815719a47fd0a65e445a6499e.jpg","width":"710","height":"310"},"pv_trackingURL":[],"click_trackingURL":[],"jump":"{\"type\":\"103\",\"class_name\":\"MSJWebAdvViewController\",\"property\":{\"urlString\":\"https:\\/\\/www.meishij.net\\/huodong\\/zt_detail.php?id=1007\",\"goodsSource\":\"4,1007\"}}"},{"cover_img":{"big":"http://s1.ig.meishij.net/p/20171204/8f160813a37491d2f20f3662baf00af6.jpg","width":"710","height":"310"},"pv_trackingURL":[],"click_trackingURL":[],"jump":"{\"type\":\"103\",\"class_name\":\"MSJWebAdvViewController\",\"property\":{\"urlString\":\"https:\\/\\/i.meishi.cc\\/g\\/transit.php?ename=3007\",\"goodsSource\":\"4,3007\"}}"}]
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
