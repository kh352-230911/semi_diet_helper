package com.sh.diet.point.model.entity;

import java.time.LocalDate;

public class PointCount {
    String pcNo;
    LocalDate regDate;
    int getPoint;
    String memberNo;
    String dailyNo;
    String acNo;

    public PointCount() {
    }


    public PointCount(String pcNo, LocalDate regDate, int getPoint, String memberNo, String dailyNo, String acNo) {
        this.pcNo = pcNo;
        this.regDate = regDate;
        this.getPoint = getPoint;
        this.memberNo = memberNo;
        this.dailyNo = dailyNo;
        this.acNo = acNo;
    }

    public String getPcNo() {
        return pcNo;
    }

    public void setPcNo(String pcNo) {
        this.pcNo = pcNo;
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

    @Override
    public String toString() {
        return "PointCount{" +
                "pcNo='" + pcNo + '\'' +
                ", regDate=" + regDate +
                ", getPoint=" + getPoint +
                ", memberNo='" + memberNo + '\'' +
                ", dailyNo='" + dailyNo + '\'' +
                ", acNo='" + acNo + '\'' +
                '}';
    }
}
