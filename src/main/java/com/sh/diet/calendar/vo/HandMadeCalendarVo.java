package com.sh.diet.calendar.vo;

import com.sh.diet.calendar.entity.HandMadeCalendar;
import com.sh.diet.daily.model.entity.DailyRecode;

public class HandMadeCalendarVo {
    HandMadeCalendar handMadeCalendar;
    DailyRecode dailyRecode;

    public HandMadeCalendarVo() {

    }

    public HandMadeCalendarVo(HandMadeCalendar handMadeCalendar, DailyRecode dailyRecode) {
        this.handMadeCalendar = handMadeCalendar;
        this.dailyRecode = dailyRecode;
    }

    public HandMadeCalendar getHandMadeCalendar() {
        return handMadeCalendar;
    }

    public void setHandMadeCalendar(HandMadeCalendar handMadeCalendar) {
        this.handMadeCalendar = handMadeCalendar;
    }

    public DailyRecode getDailyRecode() {
        return dailyRecode;
    }

    public void setDailyRecode(DailyRecode dailyRecode) {
        this.dailyRecode = dailyRecode;
    }

    @Override
    public String toString() {
        return "HandMadeCalendarVo{" +
                "handMadeCalendar=" + handMadeCalendar +
                ", dailyRecode=" + dailyRecode +
                '}';
    }

}
