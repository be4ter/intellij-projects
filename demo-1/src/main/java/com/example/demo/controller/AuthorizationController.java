package com.example.demo.controller;

import com.example.demo.domain.AuthToken;
import com.example.demo.domain.GlobalToken;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Controller
@RequestMapping("/generate")
public class AuthorizationController {
    public static final Logger log = LoggerFactory.getLogger(AuthorizationController.class);

    @GetMapping("/code")
    public String code() {
        return String.format("redirect:https://www.fitbit.com/oauth2/authorize?response_type=%s&client_id=%s&redirect_uri=%s&scope=%s&expires_in=%d", "code", "22CZW9", "http://localhost:8080/callback", "activity heartrate location nutrition profile settings sleep social weight", (int) 604800);
    }

    @PostMapping("/token/{code}")
    public String token(@PathVariable String code) throws IOException, URISyntaxException, ParseException {
        log.info("code : " + code);
        sendPost(code);
        return "redirect:/";
    }

    private void sendPost(String code) throws IOException, URISyntaxException, ParseException {
        if (GlobalToken.isNull()) {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            CloseableHttpResponse response = httpclient.execute(getHttpPost(code));
            log.info("repose statusLine : " + response.getStatusLine());
            HttpEntity entity = response.getEntity();
            JSONObject json = getJsonObject(EntityUtils.toString(entity, "UTF-8"));
            GlobalToken.authToken = AuthToken.create(json);
        } else {
            log.info("이미 토큰이 발급 되었습니다.");
        }
    }

    private JSONObject getJsonObject(String responseString) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(responseString);
        return (JSONObject) object;
    }

    private HttpPost getHttpPost(String code) throws URISyntaxException {
        URI uri = new URIBuilder().setScheme("https").setHost("api.fitbit.com").setPath("/oauth2/token")
                .setParameter("clientId", "22CZW9").setParameter("grant_type", "authorization_code")
                .setParameter("redirect_uri", "http://localhost:8080/callback")
                .setParameter("code", code).build();
        HttpPost httpPost = new HttpPost(uri);
        httpPost.addHeader("Authorization", "Basic MjJDWlc5OjgxOWQxY2EwODE3ODMwNzNkMGZkNjRkNzI1YjAyMzgw");
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        return httpPost;
    }
}
