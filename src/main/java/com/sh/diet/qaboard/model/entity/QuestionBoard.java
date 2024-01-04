package com.sh.diet.qaboard.model.entity;

import java.time.LocalDateTime;

public class QuestionBoard {
    private String qbNo;
    private String memberNo;
    private String title;
    private String content;
    private LocalDateTime regDate;
    private int adminChoice;


    public QuestionBoard() {
    }

    public QuestionBoard(String qbNo, String memberNo, String title, String content, LocalDateTime regDate, int adminChoice) {
        this.qbNo = qbNo;
        this.memberNo = memberNo;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.adminChoice = adminChoice;
    }

    public String getQbNo() {
        return qbNo;
    }

    public void setQbNo(String qbNo) {
        this.qbNo = qbNo;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
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

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public int getAdminChoice() {
        return adminChoice;
    }

    public void setAdminChoice(int adminChoice) {
        this.adminChoice = adminChoice;
    }

    @Override
    public String toString() {
        return "QuestionBoard{" +
                "qbNo='" + qbNo + '\'' +
                ", memberNo='" + memberNo + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", regDate=" + regDate +
                ", adminChoice=" + adminChoice +
                '}';
    }
}