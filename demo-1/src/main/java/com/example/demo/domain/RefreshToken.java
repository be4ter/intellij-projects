package com.example.demo.domain;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class RefreshToken {
    private String userId;
    private String tokenType;
    private String accessToken;
    private String refreshToken;
    private String scope;

    public RefreshToken(JSONObject json) {
        this.accessToken = (String) json.get("access_token");
        this.scope = (String) json.get("scope");
        this.refreshToken = (String) json.get("refresh_token");
        this.tokenType = (String) json.get("token_type");
        this.userId = (String) json.get("user_id");
    }

    public static RefreshToken generate(String refreshToken) throws URISyntaxException, IOException, ParseException {
        URI uri = new URIBuilder().setScheme("https").setHost("api.fitbit.com").setPath("/oauth2/token")
                .setParameter("grant_type", "refresh_token")
                .setParameter("refresh_token", refreshToken).build();
        HttpPost httpPost = new HttpPost(uri);
        httpPost.addHeader("Authorization", "Basic MjJDWlc5OjgxOWQxY2EwODE3ODMwNzNkMGZkNjRkNzI1YjAyMzgw");
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = httpclient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(responseString);
        return new RefreshToken((JSONObject) object);
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
