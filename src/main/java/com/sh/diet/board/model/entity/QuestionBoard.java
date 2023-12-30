package com.sh.diet.board.model.entity;

import java.time.LocalDateTime;

public class QuestionBoard {
    private String qbNo;
    private String memberNo;
    private String title;
    private String content;
    private int count;
    private LocalDateTime regDate;

    public QuestionBoard() {
    }

    public QuestionBoard(String qbNo, String memberNo, String title, String content, int count, LocalDateTime regDate) {
        this.qbNo = qbNo;
        this.memberNo = memberNo;
        this.title = title;
        this.content = content;
        this.count = count;
        this.regDate = regDate;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "QuestionBoard{" +
                "qbNo='" + qbNo + '\'' +
                ", memberNo='" + memberNo + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", count=" + count +
                ", regDate=" + regDate +
                '}';
    }
}