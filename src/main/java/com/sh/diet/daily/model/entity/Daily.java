package com.sh.diet.daily.model.entity;

public class Daily {
    int dailyYear;
    int dailyMonth;
    int dailyDayOfMonth;
    char dailyDayOfWeek;
    public Daily() {

    }

    public Daily(int dailyYear, int dailyMonth, int dailyDayOfMonth, char dailyDayOfWeek) {
        this.dailyYear = dailyYear;
        this.dailyMonth = dailyMonth;
        this.dailyDayOfMonth = dailyDayOfMonth;
        this.dailyDayOfWeek = dailyDayOfWeek;
    }

    public int getDailyYear() {
        return dailyYear;
    }

    public void setDailyYear(int dailyYear) {
        this.dailyYear = dailyYear;
    }

    public int getDailyMonth() {
        return dailyMonth;
    }

    public void setDailyMonth(int dailyMonth) {
        this.dailyMonth = dailyMonth;
    }

    public int getDailyDayOfMonth() {
        return dailyDayOfMonth;
    }

    public void setDailyDayOfMonth(int dailyDayOfMonth) {
        this.dailyDayOfMonth = dailyDayOfMonth;
    }

    public char getDailyDayOfWeek() {
        return dailyDayOfWeek;
    }

    public void setDailyDayOfWeek(char dailyDayOfWeek) {
        this.dailyDayOfWeek = dailyDayOfWeek;
    }

    @Override
    public String toString() {
        return "Daily{" +
                "dailyYear=" + dailyYear +
                ", dailyMonth=" + dailyMonth +
                ", dailyDayOfMonth=" + dailyDayOfMonth +
                ", dailyDayOfWeek=" + dailyDayOfWeek +
                '}';
    }
}



