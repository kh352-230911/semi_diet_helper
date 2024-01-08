package com.sh.diet.exercise.model.vo;

import com.sh.diet.exercise.model.entity.ExerciseData;
import com.sh.diet.exercise.model.entity.ScrapExercise;
import com.sh.diet.member.model.entity.Member;

public class ExerciseDataVo extends ExerciseData {
    private Member member;
    private ScrapExercise scrapExercise;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public ScrapExercise getScrapExercise() {
        return scrapExercise;
    }

    public void setScrapExercise(ScrapExercise scrapExercise) {
        this.scrapExercise = scrapExercise;
    }

    @Override
    public String toString() {
        return "ExerciseDataVo{" +
                "member=" + member +
                ", scrapExercise=" + scrapExercise +
                "} " + super.toString();
    }
}
