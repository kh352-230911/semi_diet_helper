package com.sh.diet.qaboard.model.vo;

import com.sh.diet.member.model.entity.Member;
import com.sh.diet.qaboard.model.entity.QuestionBoard;

public class QuestionBoardVo extends QuestionBoard {
    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "QuestionBoardVo{" +
                "member=" + member +
                "} " + super.toString();
    }
}
