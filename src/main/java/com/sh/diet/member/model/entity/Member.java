package com.sh.diet.member.model.entity;

import java.time.LocalDate;

public class Member {

    private String memberNo;
    private String memberId;
    private String password;
    private String name;
    private String nickName;
    private String height;
    private Role role;

    private LocalDate regDate;
    private String birthDay;
    private int weightLossGoal;
    private int point;
    private String answer;
    private String localNo;
    private String titleNo;

    public Member(String memberNo, String memberId, String password, String name, String nickName, String height, Role role, LocalDate regDate, String birthDay, int weightLossGoal, int point, String answer, String localNo, String titleNo) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.height = height;
        this.role = role;
        this.regDate = regDate;
        this.birthDay = birthDay;
        this.weightLossGoal = weightLossGoal;
        this.point = point;
        this.answer = answer;
        this.localNo = localNo;
        this.titleNo = titleNo;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo='" + memberNo + '\'' +
                ", memberId='" + memberId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", height='" + height + '\'' +
                ", role=" + role +
                ", regDate=" + regDate +
                ", birthDay='" + birthDay + '\'' +
                ", weightLossGoal=" + weightLossGoal +
                ", point=" + point +
                ", answer='" + answer + '\'' +
                ", localNo='" + localNo + '\'' +
                ", titleNo='" + titleNo + '\'' +
                '}';
    }

    public Member() {
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getWeightLossGoal() {
        return weightLossGoal;
    }

    public void setWeightLossGoal(int weightLossGoal) {
        this.weightLossGoal = weightLossGoal;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getLocalNo() {
        return localNo;
    }

    public void setLocalNo(String localNo) {
        this.localNo = localNo;
    }

    public String getTitleNo() {
        return titleNo;
    }

    public void setTitleNo(String titleNo) {
        this.titleNo = titleNo;
    }
}
