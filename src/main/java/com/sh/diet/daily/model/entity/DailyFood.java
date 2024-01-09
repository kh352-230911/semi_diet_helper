package com.sh.diet.daily.model.entity;

public class DailyFood {
    private String dfNo;
    private FoodTime foodTime;
    private String foodNo;
    private String DailyNo;

    public DailyFood() {
    }

    public DailyFood(String dfNo, FoodTime foodTime, String foodNo, String dailyNo) {
        this.dfNo = dfNo;
        this.foodTime = foodTime;
        this.foodNo = foodNo;
        this.DailyNo = dailyNo;
    }

    public String getDfNo() {
        return dfNo;
    }

    public void setDfNo(String dfNo) {
        this.dfNo = dfNo;
    }

    public FoodTime getFoodTime() {
        return foodTime;
    }

    public void setFoodTime(FoodTime foodTime) {
        this.foodTime = foodTime;
    }

    public String getFoodNo() {
        return foodNo;
    }

    public void setFoodNo(String foodNo) {
        this.foodNo = foodNo;
    }

    public String getDailyNo() {
        return DailyNo;
    }

    public void setDailyNo(String dailyNo) {
        DailyNo = dailyNo;
    }

    @Override
    public String toString() {
        return "DailyFood{" +
                "dfNo='" + dfNo + '\'' +
                ", foodTime=" + foodTime +
                ", foodNo='" + foodNo + '\'' +
                ", DailyNo='" + DailyNo + '\'' +
                '}';
    }
}
