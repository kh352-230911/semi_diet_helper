package com.sh.diet.daily.model.entity;

import java.time.LocalDate;

public class DailyRecode {
    String dailyNo;
    int dailyWeight;
    String memberNo;
    LocalDate recodeDate;
    boolean pointCheck;

    public DailyRecode() {
    }

    public DailyRecode(String dailyNo, int dailyWeight, String memberNo, LocalDate recodeDate, boolean pointCheck) {
        this.dailyNo = dailyNo;
        this.dailyWeight = dailyWeight;
        this.memberNo = memberNo;
        this.recodeDate = recodeDate;
        this.pointCheck = pointCheck;
    }

    public String getDailyNo() {
        return dailyNo;
    }

    public void setDailyNo(String dailyNo) {
        this.dailyNo = dailyNo;
    }

    public int getDailyWeight() {
        return dailyWeight;
    }

    public void setDailyWeight(int dailyWeight) {
        this.dailyWeight = dailyWeight;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public LocalDate getRecodeDate() {
        return recodeDate;
    }

    public void setRecodeDate(LocalDate recodeDate) {
        this.recodeDate = recodeDate;
    }

    public boolean isPointCheck() {
        return pointCheck;
    }

    public void setPointCheck(boolean pointCheck) {
        this.pointCheck = pointCheck;
    }

    @Override
    public String toString() {
        return "DailyRecode{" +
                "dailyNo='" + dailyNo + '\'' +
                ", dailyWeight=" + dailyWeight +
                ", memberNo='" + memberNo + '\'' +
                ", recodeDate=" + recodeDate +
                ", pointCheck=" + pointCheck +
                '}';
    }
}

