package com.weibo.meishijie.bean.home_recommend;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/12/27.
 */

public class Recipes {
    /**
     * title : 最新菜谱
     * items : [{"id":"1875569","title":"反沙芋头","img":"http://s1.st.meishij.net/r/168/44/9198668/a9198668_151425460391173.jpg","jump":"{\"type\":\"5\",\"class_name\":\"MSRecipeDetailController\",\"property\":{\"recipeId\":\"1875569\"}}","author":{"if_v":"1","id":"9198668","nickname":"小圆食记","avatar_url":"http://s1.st.meishij.net/user/168/44/st9198668_148954829475356.jpg"}},{"id":"1875568","title":"幻彩蒸蛋","img":"http://s1.st.meishij.net/r/21/118/3967021/a3967021_151425283655262.jpg","jump":"{\"type\":\"5\",\"class_name\":\"MSRecipeDetailController\",\"property\":{\"recipeId\":\"1875568\"}}","author":{"if_v":"1","id":"3967021","nickname":"萌城美食","avatar_url":"http://s1.st.meishij.net/user/21/118/st3967021_148956700346103.jpg"}},{"id":"1875566","title":"百香果果酱 #下午茶#","img":"http://s1.st.meishij.net/r/143/162/2728143/a2728143_151425384527191.jpg","jump":"{\"type\":\"5\",\"class_name\":\"MSRecipeDetailController\",\"property\":{\"recipeId\":\"1875566\"}}","author":{"if_v":"1","id":"2728143","nickname":"Qiuyue0815","avatar_url":"http://s1.st.meishij.net/user/143/162/st2728143_03604.jpg"}},{"id":"1875565","title":"喜沙肉","img":"http://s1.st.meishij.net/r/114/34/1258614/a1258614_151425217485604.jpg","jump":"{\"type\":\"5\",\"class_name\":\"MSRecipeDetailController\",\"property\":{\"recipeId\":\"1875565\"}}","author":{"if_v":"1","id":"1258614","nickname":"万山红","avatar_url":"http://s1.st.meishij.net/user/114/34/st1258614_59132.jpg"}},{"id":"1875563","title":"海米炒青椒","img":"http://s1.st.meishij.net/r/47/119/5279797/a5279797_151425034630290.jpg","jump":"{\"type\":\"5\",\"class_name\":\"MSRecipeDetailController\",\"property\":{\"recipeId\":\"1875563\"}}","author":{"if_v":"1","id":"5279797","nickname":"宝妈小厨","avatar_url":"http://s1.st.meishij.net/user/47/119/st5279797_144824870849966.jpg"}},{"id":"1875562","title":"蕃茄虾","img":"http://s1.st.meishij.net/r/109/94/3273609/a3273609_151424518525114.jpg","jump":"{\"type\":\"5\",\"class_name\":\"MSRecipeDetailController\",\"property\":{\"recipeId\":\"1875562\"}}","author":{"if_v":"1","id":"3273609","nickname":"雪冰姑娘","avatar_url":"http://s1.st.meishij.net/user/109/94/st3273609_150285374194545.jpg"}},{"id":"1875560","title":"香糯紫薯南瓜饼","img":"http://s1.st.meishij.net/r/173/81/3832923/a3832923_151424072122362.jpg","jump":"{\"type\":\"5\",\"class_name\":\"MSRecipeDetailController\",\"property\":{\"recipeId\":\"1875560\"}}","author":{"if_v":"1","id":"3832923","nickname":"食·色","avatar_url":"http://s1.st.meishij.net/user/173/81/st3832923_142718761933940.jpg"}},{"id":"1875558","title":"雷笋烧大头菜","img":"http://s1.st.meishij.net/r/229/162/3853229/a3853229_151423343007790.jpg","jump":"{\"type\":\"5\",\"class_name\":\"MSRecipeDetailController\",\"property\":{\"recipeId\":\"1875558\"}}","author":{"if_v":"1","id":"3853229","nickname":"花鱼儿","avatar_url":"http://s1.st.meishij.net/user/229/162/st3853229_142752213856825.jpg"}},{"id":"1875556","title":"果酱烤鸡翅#夜宵#","img":"http://s1.st.meishij.net/r/44/110/4152544/a4152544_151427819040554.jpg","jump":"{\"type\":\"5\",\"class_name\":\"MSRecipeDetailController\",\"property\":{\"recipeId\":\"1875556\"}}","author":{"if_v":"1","id":"4152544","nickname":"火镀红叶","avatar_url":"http://s1.st.meishij.net/user/44/110/st4152544_151219210732708.jpg"}},{"id":"1875555","title":"银耳皂角米红枣羹","img":"http://s1.st.meishij.net/r/115/102/588115/a588115_151427930679652.jpg","jump":"{\"type\":\"5\",\"class_name\":\"MSRecipeDetailController\",\"property\":{\"recipeId\":\"1875555\"}}","author":{"if_v":"1","id":"588115","nickname":"香儿厨房","avatar_url":"http://s1.st.meishij.net/user/115/102/st588115_148484096151095.jpg"}},{"id":"","title":"","img":"http://s1.st.meishij.net/r/168/44/9198668/a9198668_151425460391173.jpg","is_more":"1","jump":"{\"type\":\"111\",\"class_name\":\"MSNewRecipeListController\"}"}]
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
         * id : 1875569
         * title : 反沙芋头
         * img : http://s1.st.meishij.net/r/168/44/9198668/a9198668_151425460391173.jpg
         * jump : {"type":"5","class_name":"MSRecipeDetailController","property":{"recipeId":"1875569"}}
         * author : {"if_v":"1","id":"9198668","nickname":"小圆食记","avatar_url":"http://s1.st.meishij.net/user/168/44/st9198668_148954829475356.jpg"}
         * is_more : 1
         */

        @SerializedName("id")
        private String itemsId;
        private String title;
        private String img;
        private String jump;
        private Author author;
        private String is_more;

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

        public String getJump() {
            return jump;
        }

        public void setJump(String jump) {
            this.jump = jump;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        public String getIs_more() {
            return is_more;
        }

        public void setIs_more(String is_more) {
            this.is_more = is_more;
        }

        public static class Author {
            /**
             * if_v : 1
             * id : 9198668
             * nickname : 小圆食记
             * avatar_url : http://s1.st.meishij.net/user/168/44/st9198668_148954829475356.jpg
             */

            private String if_v;
            @SerializedName("id")
            private String authorId;
            private String nickname;
            private String avatar_url;

            public String getIf_v() {
                return if_v;
            }

            public void setIf_v(String if_v) {
                this.if_v = if_v;
            }

            public String getAuthorId() {
                return authorId;
            }

            public void setAuthorId(String authorId) {
                this.authorId = authorId;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }
        }
    }
}
