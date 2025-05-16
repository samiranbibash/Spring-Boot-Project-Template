package com.tutorial.spring.controller;

import com.tutorial.spring.config.CustomMessageSource;
import com.tutorial.spring.constants.SuccessConstants;
import com.tutorial.spring.dto.GlobalApiResponse;
import com.tutorial.spring.enums.ResponseStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseController {
    protected static final ResponseStatus API_SUCCESS_STATUS = ResponseStatus.SUCCESS;
    protected static final ResponseStatus API_FAILURE_STATUS = ResponseStatus.FAILURE;
    @Autowired
    protected CustomMessageSource customMessageSource;

    protected String permissionName = this.getClass().getSimpleName();
    protected String moduleName;

    protected GlobalApiResponse successResponse(String message, Object data) {
        GlobalApiResponse response = new GlobalApiResponse();
        response.setStatus(API_SUCCESS_STATUS);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    protected GlobalApiResponse successResponse(String message) {
        GlobalApiResponse response = new GlobalApiResponse();
        response.setStatus(API_SUCCESS_STATUS);
        response.setMessage(message);
        return response;
    }

    protected GlobalApiResponse successCreate(String moduleName, Object data) {
        GlobalApiResponse response = new GlobalApiResponse();
        String message = customMessageSource.get(SuccessConstants.SUCCESS_CREATE, customMessageSource.get(moduleName));
        response.setStatus(API_SUCCESS_STATUS);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

}
