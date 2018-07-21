package com.example.demo.controller;

import com.example.demo.utils.CodeUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class CodeController {
    public static final Logger log = LoggerFactory.getLogger(CodeController.class);

    public CloseableHttpResponse createCodeGenerateURI(String clientId, String callbackAddress, String scope, String expiresTime) throws IOException {
        URI uri = null;
        try {
            uri = new URIBuilder().setScheme("https").setHost("api.fitbit.com").setPath("/oauth2/authorize")
                    .setParameter("response_type", CodeUtils.RESPONSE_TYPE)
                    .setParameter("client_id", clientId).setParameter("redirect_uri", callbackAddress)
                    .setParameter("scope", scope).setParameter("expires_in", expiresTime).build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        log.info("uri : " + uri);
        return createHttpGet(uri);
    }

    public CloseableHttpResponse createHttpGet(URI uri) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        return httpClient.execute(new HttpGet(uri));
    }
}