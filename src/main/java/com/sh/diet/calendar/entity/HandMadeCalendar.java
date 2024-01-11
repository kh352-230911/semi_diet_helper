package com.sh.diet.calendar.entity;

import com.sh.diet.daily.model.entity.DailyRecode;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

public class HandMadeCalendar {

    private int calcYear;
    private int calcMonth;
    private int calcDay;
    private char calcDayOfWeek;
    public static int currentDayOfMonthInJspTitle;

    // 일일포인트 부여 여부, 일일 몸무게를 조회하기 위한 dailyRecode의 요소들
    private String dailyNo;
    private int dailyWeight;
    private int memberNo;
    private LocalDate recodeDate;
    private boolean pointCheck;

    public HandMadeCalendar() {
    }

    public HandMadeCalendar(int calcYear, int calcMonth, int calcDay, char calcDayOfWeek, String dailyNo, int dailyWeight,
                            int memberNo, LocalDate recodeDate, boolean pointCheck) {
        this.calcYear = calcYear;
        this.calcMonth = calcMonth;
        this.calcDay = calcDay;
        this.calcDayOfWeek = calcDayOfWeek;
        this.dailyNo = dailyNo;
        this.dailyWeight = dailyWeight;
        this.memberNo = memberNo;
        this.recodeDate = recodeDate;
        this.pointCheck = pointCheck;
    }

    public int getCalcYear() {
        return calcYear;
    }

    public void setCalcYear(int calcYear) {
        this.calcYear = calcYear;
    }

    public int getCalcMonth() {
        return calcMonth;
    }

    public void setCalcMonth(int calcMonth) {
        this.calcMonth = calcMonth;
    }

    public int getCalcDay() {
        return calcDay;
    }

    public void setCalcDay(int calcDay) {
        this.calcDay = calcDay;
    }

    public char getCalcDayOfWeek() {
        return calcDayOfWeek;
    }

    public void setCalcDayOfWeek(char calcDayOfWeek) {
        this.calcDayOfWeek = calcDayOfWeek;
    }

    public static int getCurrentDayOfMonthInJspTitle() {
        return currentDayOfMonthInJspTitle;
    }

    public static void setCurrentDayOfMonthInJspTitle(int currentDayOfMonthInJspTitle) {
        HandMadeCalendar.currentDayOfMonthInJspTitle = currentDayOfMonthInJspTitle;
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

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
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
        return "HandMadeCalendar{" +
                "calcYear=" + calcYear +
                ", calcMonth=" + calcMonth +
                ", calcDay=" + calcDay +
                ", calcDayOfWeek=" + calcDayOfWeek +
                ", dailyNo='" + dailyNo + '\'' +
                ", dailyWeight=" + dailyWeight +
                ", memberNo=" + memberNo +
                ", recodeDate=" + recodeDate +
                ", pointCheck=" + pointCheck +
                '}';
    }
}
