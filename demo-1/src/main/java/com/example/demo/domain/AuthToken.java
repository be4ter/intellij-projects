package com.example.demo.domain;

import org.json.simple.JSONObject;

public class AuthToken {
    private String userId;
    private String tokenType;
    private String accessToken;
    private String refreshToken;
    private String scope;

    private AuthToken(JSONObject json) {
        this.accessToken = (String) json.get("access_token");
        this.scope = (String) json.get("scope");
        this.refreshToken = (String) json.get("refresh_token");
        this.tokenType = (String) json.get("token_type");
        this.userId = (String) json.get("user_id");
    }

    public static AuthToken create(JSONObject json) {
        return new AuthToken(json);
    }

    public String getUserId() {
        return userId;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getScope() {
        return scope;
    }
}
