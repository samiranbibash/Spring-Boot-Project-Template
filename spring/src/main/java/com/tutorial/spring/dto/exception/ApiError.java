package com.tutorial.spring.dto.exception;

import com.tutorial.spring.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private ResponseStatus status;
    private int httpCode;
    private String message;
    private List<String> errors;

    public ApiError(ResponseStatus status, final int httpCode, final String message, final String error) {
        super();
        this.status = status;
        this.httpCode = httpCode;
        this.message = message;
        errors = Arrays.asList(error);
    }

}
