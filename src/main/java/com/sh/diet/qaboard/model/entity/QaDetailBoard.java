package com.sh.diet.qaboard.model.entity;

import java.time.LocalDateTime;

public class QaDetailBoard {
    private String acNo;
    private String memberNo;
    private String qbNo;
    private String title;
    private String content;
    private int choice;
    private int likeCount;
    private LocalDateTime regDate;

    public QaDetailBoard() {
    }

    public QaDetailBoard(String acNo, String memberNo, String qbNo, String title, String content, int choice, int likeCount, LocalDateTime regDate) {
        this.acNo = acNo;
        this.memberNo = memberNo;
        this.qbNo = qbNo;
        this.title = title;
        this.content = content;
        this.choice = choice;
        this.likeCount = likeCount;
        this.regDate = regDate;
    }

    public String getAcNo() {
        return acNo;
    }

    public void setAcNo(String acNo) {
        this.acNo = acNo;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getQbNo() {
        return qbNo;
    }

    public void setQbNo(String qbNo) {
        this.qbNo = qbNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "QaDetailBoard{" +
                "acNo='" + acNo + '\'' +
                ", memberNo='" + memberNo + '\'' +
                ", qbNo='" + qbNo + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", choice=" + choice +
                ", likeCount=" + likeCount +
                ", regDate=" + regDate +
                '}';
    }
}
