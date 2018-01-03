package com.weibo.meishijie.mvp.model.entities.home_recommend;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/12/27.
 */

public class Sancan {
    /**
     * title : 早餐
     * items : [{"id":"1875062","title":"炸鸡汉堡","img":"http://s1.ig.meishij.net/p/20171225/732d01fcdfc70ecab0ddbeaa7001e1e9.jpg","recommend_msg":"这样的早餐，真是营养丰富，赏心悦目呀","jump":"{\"type\":\"5\",\"class_name\":\"MSRecipeDetailController\",\"property\":{\"recipeId\":\"1875062\"}}"},{"id":"1875234","title":"彩色沙拉","img":"http://s1.ig.meishij.net/p/20171225/adf9712409aa1436c232a8845119d671.jpg","recommend_msg":"色彩诱人，美味无敌，营养又美味","jump":"{\"type\":\"5\",\"class_name\":\"MSRecipeDetailController\",\"property\":{\"recipeId\":\"1875234\"}}"},{"id":"1862790","title":"滋补气血饮","img":"http://s1.ig.meishij.net/p/20171225/c1c4d69bc28591c287d4b8303fc0f928.jpg","recommend_msg":"来杯温热的花生牛奶暖暖身心","jump":"{\"type\":\"5\",\"class_name\":\"MSRecipeDetailController\",\"property\":{\"recipeId\":\"1862790\"}}"}]
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
    public static class Items {
        /**
         * id : 1875062
         * title : 炸鸡汉堡
         * img : http://s1.ig.meishij.net/p/20171225/732d01fcdfc70ecab0ddbeaa7001e1e9.jpg
         * recommend_msg : 这样的早餐，真是营养丰富，赏心悦目呀
         * jump : {"type":"5","class_name":"MSRecipeDetailController","property":{"recipeId":"1875062"}}
         */

        @SerializedName("id")
        private String itemsId;
        private String title;
        private String img;
        private String recommend_msg;
        private String jump;

        public String getItemsId() {
            return itemsId;
        }

        public void setItemsId(String itemsId) {
            this.itemsId = itemsId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getRecommend_msg() {
            return recommend_msg;
        }

        public void setRecommend_msg(String recommend_msg) {
            this.recommend_msg = recommend_msg;
        }

        public String getJump() {
            return jump;
        }

        public void setJump(String jump) {
            this.jump = jump;
        }
    }
}
