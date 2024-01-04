package com.sh.diet.exercise.model.entity;

public class ExerciseData {
    String exNo;
    String exName;
    int kcal;
    String bodyPart;
    String exUrl;

    public ExerciseData() {

    }

    public ExerciseData(String exNo, String exName, int kcal, String bodyPart, String exUrl) {
        this.exNo = exNo;
        this.exName = exName;
        this.kcal = kcal;
        this.bodyPart = bodyPart;
        this.exUrl = exUrl;
    }

    public String getExNo() {
        return exNo;
    }

    public void setExNo(String exNo) {
        this.exNo = exNo;
    }

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getExUrl() {
        return exUrl;
    }

    public void setExUrl(String exUrl) {
        this.exUrl = exUrl;
    }

    @Override
    public String toString() {
        return "ExerciseData{" +
                "exNo='" + exNo + '\'' +
                ", exName='" + exName + '\'' +
                ", kcal=" + kcal +
                ", bodyPart='" + bodyPart + '\'' +
                ", exUrl='" + exUrl + '\'' +
                '}';
    }
}
