package com.crud.tasks.domain;

import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
public class Mail {

    private final String mailTo;
    private final String subject;
    private final String message;
    private final String toCc;

    @Override
    public String toString() {
        return "Mail{" +
                "mailTo='" + mailTo + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", toCc='" + toCc + '\'' +
                '}';
    }
}
