package com.example.arquiBack.dto;

public class ResponseDto<T> {
    private int code;
    private T response;
    private String errorMessage;

    public ResponseDto() {
    }

    public ResponseDto(int code, T response, String errorMessage) {
        this.code = code;
        this.response = response;
        this.errorMessage = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "code=" + code +
                ", response=" + response +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}