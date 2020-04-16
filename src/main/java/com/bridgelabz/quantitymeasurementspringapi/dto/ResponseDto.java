package com.bridgelabz.quantitymeasurementspringapi.dto;

public class ResponseDto {
    private Object value;
    private String message;
    private Integer statusCode;

    public ResponseDto(double value, String message, Integer statusCode) {
        this.value = value;
        this.message = message;
        this.statusCode = statusCode;
    }
    public Object getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
