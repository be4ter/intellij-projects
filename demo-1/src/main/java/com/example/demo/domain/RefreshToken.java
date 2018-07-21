package com.example.demo.domain;

import com.example.demo.Utils.GlobalExecute;
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
        HttpPost httpPost = new HttpPost(createURI(refreshToken));
        CloseableHttpResponse response = GlobalExecute.postMethodRefresh(httpPost);
        HttpEntity entity = response.getEntity();
        JSONParser jsonParser = new JSONParser();
        return new RefreshToken((JSONObject) jsonParser.parse(EntityUtils.toString(entity, "UTF-8")));
    }

    private static URI createURI(String refreshToken) throws URISyntaxException {
        return new URIBuilder().setScheme("https").setHost("api.fitbit.com").setPath("/oauth2/token")
                .setParameter("grant_type", "refresh_token")
                .setParameter("refresh_token", refreshToken).build();
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
