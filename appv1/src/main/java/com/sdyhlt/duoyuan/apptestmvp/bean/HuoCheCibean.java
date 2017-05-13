package com.sdyhlt.duoyuan.apptestmvp.bean;

import java.util.List;

/**
 * Created by jingsheng on 2017/2/9.
 */

public class HuoCheCibean {
    /**
     * msg : success
     * result : [{"arriveTime":"----","endStationName":"北京西","startStationName":"深圳","startTime":"14:50","stationName":"深圳","stationNo":"01","stationTrainCode":"Z108","stopoverTime":"----","trainClassName":"直特"},{"arriveTime":"16:10","startTime":"16:16","stationName":"惠州","stationNo":"02","stopoverTime":"6分钟"},{"arriveTime":"20:29","startTime":"20:47","stationName":"赣州","stationNo":"03","stopoverTime":"18分钟"},{"arriveTime":"22:38","startTime":"22:42","stationName":"吉安","stationNo":"04","stopoverTime":"4分钟"},{"arriveTime":"00:54","startTime":"01:03","stationName":"南昌","stationNo":"05","stopoverTime":"9分钟"},{"arriveTime":"05:58","startTime":"06:05","stationName":"阜阳","stationNo":"06","stopoverTime":"7分钟"},{"arriveTime":"08:23","startTime":"08:25","stationName":"菏泽","stationNo":"07","stopoverTime":"2分钟"},{"arriveTime":"09:32","startTime":"09:36","stationName":"聊城","stationNo":"08","stopoverTime":"4分钟"},{"arriveTime":"10:56","startTime":"10:59","stationName":"衡水","stationNo":"09","stopoverTime":"3分钟"},{"arriveTime":"13:14","startTime":"13:14","stationName":"北京西","stationNo":"10","stopoverTime":"----"}]
     * retCode : 200
     */

    private String msg;
    private String retCode;
    private List<ResultBean> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * arriveTime : ----
         * endStationName : 北京西
         * startStationName : 深圳
         * startTime : 14:50
         * stationName : 深圳
         * stationNo : 01
         * stationTrainCode : Z108
         * stopoverTime : ----
         * trainClassName : 直特
         */

        private String arriveTime;
        private String endStationName;
        private String startStationName;
        private String startTime;
        private String stationName;
        private String stationNo;
        private String stationTrainCode;
        private String stopoverTime;
        private String trainClassName;

        public String getArriveTime() {
            return arriveTime;
        }

        public void setArriveTime(String arriveTime) {
            this.arriveTime = arriveTime;
        }

        public String getEndStationName() {
            return endStationName;
        }

        public void setEndStationName(String endStationName) {
            this.endStationName = endStationName;
        }

        public String getStartStationName() {
            return startStationName;
        }

        public void setStartStationName(String startStationName) {
            this.startStationName = startStationName;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public String getStationNo() {
            return stationNo;
        }

        public void setStationNo(String stationNo) {
            this.stationNo = stationNo;
        }

        public String getStationTrainCode() {
            return stationTrainCode;
        }

        public void setStationTrainCode(String stationTrainCode) {
            this.stationTrainCode = stationTrainCode;
        }

        public String getStopoverTime() {
            return stopoverTime;
        }

        public void setStopoverTime(String stopoverTime) {
            this.stopoverTime = stopoverTime;
        }

        public String getTrainClassName() {
            return trainClassName;
        }

        public void setTrainClassName(String trainClassName) {
            this.trainClassName = trainClassName;
        }
    }
}
