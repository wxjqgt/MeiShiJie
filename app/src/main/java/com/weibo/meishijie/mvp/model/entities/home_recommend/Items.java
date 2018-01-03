package com.weibo.meishijie.mvp.model.entities.home_recommend;

/**
 * Created by Administrator on 2017/12/27.
 */

public class Items {
    /**
     * cover_img : {"big":"http://s1.ig.meishij.net/p/20171225/b8fac4e596e37afc8ae22d8503624d81.jpg","width":240,"height":132}
     * pv_trackingURL : []
     * click_trackingURL : []
     * jump : {"type":"108","class_name":"MSShangJiaContrller","property":{"urlString":"https:\/\/www.meishij.net\/huodong\/zt_detail.php?id=1015","goodsSource":""}}
     */

    private CoverImg cover_img;
    private String jump;

    public CoverImg getCover_img() {
        return cover_img;
    }

    public void setCover_img(CoverImg cover_img) {
        this.cover_img = cover_img;
    }

    public String getJump() {
        return jump;
    }

    public void setJump(String jump) {
        this.jump = jump;
    }

}
