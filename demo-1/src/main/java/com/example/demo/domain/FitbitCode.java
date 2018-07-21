package com.example.demo.domain;

public class FitbitCode {
    private String code;

    public FitbitCode() {
        this.code = null;
    }

    public FitbitCode(String code) {
        this.code = code;
    }

    public boolean isNull() {
        return code == null;
    }

    public String getCode() {
        return code;
    }
}
