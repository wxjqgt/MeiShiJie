package com.weibo.meishijie.bean.home_recommend;

/**
 * Created by Administrator on 2017/12/27.
 */

public class NavItems {
    /**
     * title : 推荐
     * type : 1
     */

    private String title;
    private String type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "NavItems{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
