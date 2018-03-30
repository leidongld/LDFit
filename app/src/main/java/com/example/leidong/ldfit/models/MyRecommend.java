package com.example.leidong.ldfit.models;

import java.util.List;

/**
 * Created by leido on 2018/3/30.
 */

public class MyRecommend {
    private List<MyRecommendBean> myRecommend;

    public List<MyRecommendBean> getMyRecommend() {
        return myRecommend;
    }

    public void setMyRecommend(List<MyRecommendBean> myRecommend) {
        this.myRecommend = myRecommend;
    }

    public static class MyRecommendBean {
        /**
         * myRecommendImage : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523021555&di=c8064708c77a1fd6f10154f23fe90ba6&imgtype=jpg&er=1&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Ff703738da9773912a5055842f2198618367ae2f6.jpg
         * myRecommendDesc : 这年头没几块腹肌真不行
         * myRecommendNote : 为什么练了那么久还是没效果
         */

        private String myRecommendImage;
        private String myRecommendDesc;
        private String myRecommendNote;

        public String getMyRecommendImage() {
            return myRecommendImage;
        }

        public void setMyRecommendImage(String myRecommendImage) {
            this.myRecommendImage = myRecommendImage;
        }

        public String getMyRecommendDesc() {
            return myRecommendDesc;
        }

        public void setMyRecommendDesc(String myRecommendDesc) {
            this.myRecommendDesc = myRecommendDesc;
        }

        public String getMyRecommendNote() {
            return myRecommendNote;
        }

        public void setMyRecommendNote(String myRecommendNote) {
            this.myRecommendNote = myRecommendNote;
        }
    }
}
