package com.sh.diet.point.model.entity;

import java.time.LocalDate;

public class PointCount {
    String pkNo;
    String memberNo;
    String dailyNo;
    String acNo;
    LocalDate regDate;
    int getPoint;

    public PointCount() {
    }

    public PointCount(String pkNo, String memberNo, String dailyNo, String acNo, LocalDate regDate, int getPoint) {
        this.pkNo = pkNo;
        this.memberNo = memberNo;
        this.dailyNo = dailyNo;
        this.acNo = acNo;
        this.regDate = regDate;
        this.getPoint = getPoint;
    }

    public String getPkNo() {
        return pkNo;
    }

    public void setPkNo(String pkNo) {
        this.pkNo = pkNo;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getDailyNo() {
        return dailyNo;
    }

    public void setDailyNo(String dailyNo) {
        this.dailyNo = dailyNo;
    }

    public String getAcNo() {
        return acNo;
    }

    public void setAcNo(String acNo) {
        this.acNo = acNo;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public int getGetPoint() {
        return getPoint;
    }

    public void setGetPoint(int getPoint) {
        this.getPoint = getPoint;
    }

    @Override
    public String toString() {
        return "PointCount{" +
                "pkNo='" + pkNo + '\'' +
                ", memberNo='" + memberNo + '\'' +
                ", dailyNo='" + dailyNo + '\'' +
                ", acNo='" + acNo + '\'' +
                ", regDate=" + regDate +
                ", getPoint=" + getPoint +
                '}';
    }

}
