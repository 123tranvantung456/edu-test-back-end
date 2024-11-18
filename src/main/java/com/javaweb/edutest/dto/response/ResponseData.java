package com.javaweb.edutest.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData <T>{
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T response;
    private final int status;
    private final String message;

    public ResponseData(T response, int statusCode, String statusMessage) {
        this.response = response;
        this.status = statusCode;
        this.message = statusMessage;
    }

    public ResponseData(int StatusCode, String StatusMessage) {
        this.status = StatusCode;
        this.message = StatusMessage;
    }
}
