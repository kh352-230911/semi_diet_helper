package com.sh.diet.qaboard.model.exception;

public class QuestionBoardException extends RuntimeException{
    public QuestionBoardException() {
    }

    public QuestionBoardException(String message) {
        super(message);
    }

    public QuestionBoardException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionBoardException(Throwable cause) {
        super(cause);
    }

    public QuestionBoardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

