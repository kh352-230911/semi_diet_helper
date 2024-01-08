package com.sh.diet.qaboard.model.vo;

import com.sh.diet.member.model.entity.Member;
import com.sh.diet.qaboard.model.entity.AnswerBoard;

public class AnswerBoardVo extends AnswerBoard {
    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "AnswerBoardVo{" +
                "member=" + member +
                "} " + super.toString();
    }
}
