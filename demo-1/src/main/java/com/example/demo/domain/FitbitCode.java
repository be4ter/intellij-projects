package com.example.demo.domain;

public class FitbitCode {
    private String code;

    public FitbitCode() {

    }

    public boolean isValid() {
        return !code.equals(null);
    }

    public boolean isNull() {
       return code == null;
    }
}
