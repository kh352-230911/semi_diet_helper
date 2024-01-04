package com.sh.diet.daily.model.entity;

public class DailyEx {
    String deNo;
    String exId;
    String dailyNo;
    int exSets;

    public DailyEx() {
    }

    public DailyEx(String deNo, String exId, String dailyNo, int exSets) {
        this.deNo = deNo;
        this.exId = exId;
        this.dailyNo = dailyNo;
        this.exSets = exSets;
    }

    public String getDeNo() {
        return deNo;
    }

    public void setDeNo(String deNo) {
        this.deNo = deNo;
    }

    public String getExId() {
        return exId;
    }

    public void setExId(String exId) {
        this.exId = exId;
    }

    public String getDailyNo() {
        return dailyNo;
    }

    public void setDailyNo(String dailyNo) {
        this.dailyNo = dailyNo;
    }

    public int getExSets() {
        return exSets;
    }

    public void setExSets(int exSets) {
        this.exSets = exSets;
    }

    @Override
    public String toString() {
        return "DailyEx{" +
                "deNo='" + deNo + '\'' +
                ", exId='" + exId + '\'' +
                ", dailyNo='" + dailyNo + '\'' +
                ", exSets=" + exSets +
                '}';
    }
}
