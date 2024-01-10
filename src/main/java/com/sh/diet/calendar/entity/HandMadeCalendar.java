package com.sh.diet.calendar.entity;

import com.sh.diet.daily.model.entity.DailyRecode;

public class HandMadeCalendar {

    private int calc_year;
    private int calc_month;
    private int calc_day;
    private char calc_dayOfWeek;

    public static int currentDayOfMonthInJspTitle;

    // 일일포인트 부여 여부, 일일 몸무게를 조회하기 위한 dailyRecode
    private DailyRecode dailyRecode;




    public HandMadeCalendar() {
    }

    public HandMadeCalendar(int calc_year, int calc_month, int calc_day, char calc_dayOfWeek, DailyRecode dailyRecode) {
        this.calc_year = calc_year;
        this.calc_month = calc_month;
        this.calc_day = calc_day;
        this.calc_dayOfWeek = calc_dayOfWeek;
        this.dailyRecode = dailyRecode;
    }


    public int getCalc_year() {
        return calc_year;
    }

    public void setCalc_year(int calc_year) {
        this.calc_year = calc_year;
    }

    public int getCalc_month() {
        return calc_month;
    }

    public void setCalc_month(int calc_month) {
        this.calc_month = calc_month;
    }

    public int getCalc_day() {
        return calc_day;
    }

    public void setCalc_day(int calc_day) {
        this.calc_day = calc_day;
    }

    public char getCalc_dayOfWeek() {
        return calc_dayOfWeek;
    }

    public void setCalc_dayOfWeek(char calc_dayOfWeek) {
        this.calc_dayOfWeek = calc_dayOfWeek;
    }

    public static int getCurrentDayOfMonthInJspTitle() {
        return currentDayOfMonthInJspTitle;
    }

    public static void setCurrentDayOfMonthInJspTitle(int currentDayOfMonthInJspTitle) {
        HandMadeCalendar.currentDayOfMonthInJspTitle = currentDayOfMonthInJspTitle;
    }

    public DailyRecode getDailyRecode() {
        return dailyRecode;
    }

    public void setDailyRecode(DailyRecode dailyRecode) {
        this.dailyRecode = dailyRecode;
    }

    @Override
    public String toString() {
        return "HandMadeCalendar{" +
                "calc_year=" + calc_year +
                ", calc_month=" + calc_month +
                ", calc_day=" + calc_day +
                ", calc_dayOfWeek=" + calc_dayOfWeek +
                ", dailyRecode=" + dailyRecode +
                '}';
    }
}
