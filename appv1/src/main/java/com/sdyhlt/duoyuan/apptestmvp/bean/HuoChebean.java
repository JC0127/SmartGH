package com.sdyhlt.duoyuan.apptestmvp.bean;

import java.util.List;

/**
 * Created by jingsheng on 2017/2/8.
 */

public class HuoChebean {

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


        private String arriveTime;
        private String endStationName;
        private String lishi;
        private String pricerw;
        private String pricewz;
        private String priceyw;
        private String priceyz;
        private String startStationName;
        private String startTime;
        private String stationTrainCode;
        private String trainClassName;
        private String priceed;
        private String pricesw;
        private String priceyd;

        private String stationName;
        private String stationNo;
        private String stopoverTime;

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

        public String getLishi() {
            return lishi;
        }

        public void setLishi(String lishi) {
            this.lishi = lishi;
        }

        public String getPricerw() {
            return pricerw;
        }

        public void setPricerw(String pricerw) {
            this.pricerw = pricerw;
        }

        public String getPricewz() {
            return pricewz;
        }

        public void setPricewz(String pricewz) {
            this.pricewz = pricewz;
        }

        public String getPriceyw() {
            return priceyw;
        }

        public void setPriceyw(String priceyw) {
            this.priceyw = priceyw;
        }

        public String getPriceyz() {
            return priceyz;
        }

        public void setPriceyz(String priceyz) {
            this.priceyz = priceyz;
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

        public String getStationTrainCode() {
            return stationTrainCode;
        }

        public void setStationTrainCode(String stationTrainCode) {
            this.stationTrainCode = stationTrainCode;
        }

        public String getTrainClassName() {
            return trainClassName;
        }

        public void setTrainClassName(String trainClassName) {
            this.trainClassName = trainClassName;
        }

        public String getPriceed() {
            return priceed;
        }

        public void setPriceed(String priceed) {
            this.priceed = priceed;
        }

        public String getPricesw() {
            return pricesw;
        }

        public void setPricesw(String pricesw) {
            this.pricesw = pricesw;
        }

        public String getPriceyd() {
            return priceyd;
        }

        public void setPriceyd(String priceyd) {
            this.priceyd = priceyd;
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

        public String getStopoverTime() {
            return stopoverTime;
        }

        public void setStopoverTime(String stopoverTime) {
            this.stopoverTime = stopoverTime;
        }
    }
}
