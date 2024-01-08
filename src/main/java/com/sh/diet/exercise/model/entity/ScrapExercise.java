package com.sh.diet.exercise.model.entity;

public class ScrapExercise {
    private String exScrapNo;
    private String memberNo;
    private String exNo;

    public ScrapExercise() {
    }

    public ScrapExercise(String exScrapNo, String memberNo, String exNo) {
        this.exScrapNo = exScrapNo;
        this.memberNo = memberNo;
        this.exNo = exNo;
    }

    public String getExScrapNo() {
        return exScrapNo;
    }

    public void setExScrapNo(String exScrapNo) {
        this.exScrapNo = exScrapNo;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getExNo() {
        return exNo;
    }

    public void setExNo(String exNo) {
        this.exNo = exNo;
    }

    @Override
    public String toString() {
        return "ScrapExercise{" +
                "exScrapNo='" + exScrapNo + '\'' +
                ", memberNo='" + memberNo + '\'' +
                ", exNo='" + exNo + '\'' +
                '}';
    }
}
