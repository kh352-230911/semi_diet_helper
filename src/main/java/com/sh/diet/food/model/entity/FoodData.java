package com.sh.diet.food.model.entity;

public class FoodData {

    String foodNo;
    String name;
    int kcal;
    float carbo;
    float prot;
    float fat;

    public FoodData() {
    }

    public FoodData(String foodNo, String name, int kcal, float caarbo, float prot, float fat) {
        this.foodNo = foodNo;
        this.name = name;
        this.kcal = kcal;
        this.carbo = carbo;
        this.prot = prot;
        this.fat = fat;
    }

    public String getFoodNo() {
        return foodNo;
    }

    public void setFoodNo(String foodNo) {
        this.foodNo = foodNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public float getCarbo() {
        return carbo;
    }

    public void setCarbo(float carbo) {
        this.carbo = carbo;
    }

    public float getProt() {
        return prot;
    }

    public void setProt(float prot) {
        this.prot = prot;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    @Override
    public String toString() {
        return "FoodData{" +
                "foodNo='" + foodNo + '\'' +
                ", name='" + name + '\'' +
                ", kcal=" + kcal +
                ", carbo=" + carbo +
                ", prot=" + prot +
                ", fat=" + fat +
                '}';
    }
}
