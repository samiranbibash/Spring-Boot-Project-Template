package com.tutorial.spring.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tutorial.spring.config.CustomMessageSource;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum ResponseStatus {
    FAILURE(0), SUCCESS(1);

    @Getter
    private final int index;
    private final CustomMessageSource customMessageSource = new CustomMessageSource();

    ResponseStatus(int index) {
        this.index = index;
    }

    public String getName() {
        if (this.equals(ResponseStatus.SUCCESS)) {
            return "success";
        } else return "failure";
    }

}
