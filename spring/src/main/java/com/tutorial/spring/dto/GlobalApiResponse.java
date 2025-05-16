package com.tutorial.spring.dto;

import com.tutorial.spring.enums.ResponseStatus;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GlobalApiResponse implements Serializable {
    private String message;
    private Object data;
    private ResponseStatus status;
}
