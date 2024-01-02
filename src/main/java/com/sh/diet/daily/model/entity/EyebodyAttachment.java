package com.sh.diet.daily.model.entity;

public class EyebodyAttachment {
    private String eaNo;
    private String dailyNo;
    private String originalFile;
    private String renamedFile;

    public EyebodyAttachment() {
    }

    public EyebodyAttachment(String eaNo, String dailyNo, String originalFile, String renamedFile) {
        this.eaNo = eaNo;
        this.dailyNo = dailyNo;
        this.originalFile = originalFile;
        this.renamedFile = renamedFile;
    }

    public String getEaNo() {
        return this.eaNo;
    }

    public void setEaNo(String eaNo) {
        this.eaNo = eaNo;
    }

    public String getDailyNo() {
        return dailyNo;
    }

    public void setDailyNo(String dailyNo) {
        this.dailyNo = dailyNo;
    }

    public String getOriginalFile() {
        return originalFile;
    }

    public void setOriginalFile(String originalFile) {
        this.originalFile = originalFile;
    }

    public String getRenamedFile() {
        return renamedFile;
    }

    public void setRenamedFile(String renamedFile) {
        this.renamedFile = renamedFile;
    }

    @Override
    public String toString() {
        return "EyebodyAttachment{" +
                "eaNo='" + eaNo + '\'' +
                ", dailyNo='" + dailyNo + '\'' +
                ", originalFile='" + originalFile + '\'' +
                ", renamedFile='" + renamedFile + '\'' +
                '}';
    }
}
