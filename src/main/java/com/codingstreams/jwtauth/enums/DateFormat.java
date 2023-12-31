package com.codingstreams.jwtauth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.format.DateTimeFormatter;
@Getter

public enum DateFormat {
    DD_MMM_YY2("dd-MMM-yy"),
    DD_MMM_YY1("dd MMM YY");

    private final String pattern;

    DateFormat(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
