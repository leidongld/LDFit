package com.example.leidong.ldfit.models;

import java.util.List;

/**
 * Created by leido on 2018/3/21.
 */
public class MyTraining {

    private List<MyTrainingBean> myTraining;

    public List<MyTrainingBean> getMyTraining() {
        return myTraining;
    }

    public void setMyTraining(List<MyTrainingBean> myTraining) {
        this.myTraining = myTraining;
    }

    public class MyTrainingBean {
        /**
         * myTrainingname : 哑铃全身循环
         * myTrainingDuration : 30
         * myTrainingDesc : 还未进行过训练  22人正在练
         * myTrainingExist : false
         */

        private String myTrainingname;
        private String myTrainingDuration;
        private String myTrainingDesc;
        private boolean myTrainingExist;

        public String getMyTrainingname() {
            return myTrainingname;
        }

        public void setMyTrainingname(String myTrainingname) {
            this.myTrainingname = myTrainingname;
        }

        public String getMyTrainingDuration() {
            return myTrainingDuration;
        }

        public void setMyTrainingDuration(String myTrainingDuration) {
            this.myTrainingDuration = myTrainingDuration;
        }

        public String getMyTrainingDesc() {
            return myTrainingDesc;
        }

        public void setMyTrainingDesc(String myTrainingDesc) {
            this.myTrainingDesc = myTrainingDesc;
        }

        public boolean isMyTrainingExist() {
            return myTrainingExist;
        }

        public void setMyTrainingExist(boolean myTrainingExist) {
            this.myTrainingExist = myTrainingExist;
        }
    }
}

