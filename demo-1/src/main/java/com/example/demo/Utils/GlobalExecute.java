package com.example.demo.Utils;

import com.example.demo.domain.FitbitCode;
import com.example.demo.domain.GlobalToken;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class GlobalExecute {
    public static CloseableHttpResponse tokenGenerate(FitbitCode code) throws URISyntaxException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        return httpClient.execute(getHttpPost(code.getCode()));
    }

    private static HttpUriRequest getHttpPost(String code) throws URISyntaxException {
        URI uri = new URIBuilder().setScheme("https").setHost("api.fitbit.com").setPath("/oauth2/token")
                .setParameter("clientId", "22CZW9").setParameter("grant_type", "authorization_code")
                .setParameter("redirect_uri", "http://localhost:8080/callback")
                .setParameter("code", code).build();
        HttpPost httpPost = new HttpPost(uri);
        httpPost.addHeader("Authorization", "Basic MjJDWlc5OjgxOWQxY2EwODE3ODMwNzNkMGZkNjRkNzI1YjAyMzgw");
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        return httpPost;
    }


    public static CloseableHttpResponse getMethod(HttpGet dataURI, String accessToken) throws IOException {
        dataURI.addHeader("Authorization", "Bearer " + accessToken);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        return httpclient.execute(dataURI);
    }

    public static CloseableHttpResponse postMethodRevoke(HttpPost httpPost) throws IOException {
        httpPost.addHeader("Authorization", "Basic MjJDWlc5OjgxOWQxY2EwODE3ODMwNzNkMGZkNjRkNzI1YjAyMzgw");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        return httpclient.execute(httpPost);
    }

    public static CloseableHttpResponse postMethodRefresh(HttpPost httpPost) throws IOException {
        httpPost.addHeader("Authorization", "Basic MjJDWlc5OjgxOWQxY2EwODE3ODMwNzNkMGZkNjRkNzI1YjAyMzgw");
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        return httpclient.execute(httpPost);
    }
}
