package com.example.demo.controller;

import com.example.demo.domain.GlobalToken;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Controller
@RequestMapping("/revoke")
public class RevokeController {
    public static final Logger log = LoggerFactory.getLogger(RevokeController.class);

    @PostMapping("/token")
    public String revoke() throws IOException, URISyntaxException {
        sendPost();
        return "redirect:/";
    }

    private void sendPost() throws URISyntaxException, IOException {
        log.info("token : " + GlobalToken.getAuthToken().getAccessToken());
        URI uri = new URIBuilder().setScheme("https").setHost("api.fitbit.com").setPath("/oauth2/revoke").
                setParameter("token", GlobalToken.getAuthToken().getAccessToken()).build();
        HttpPost httpPost = new HttpPost(uri);
        httpPost.addHeader("Authorization", "Basic MjJDWlc5OjgxOWQxY2EwODE3ODMwNzNkMGZkNjRkNzI1YjAyMzgw");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = httpclient.execute(httpPost);
        log.info("repose statusLine : " + response.getStatusLine().getStatusCode());

    }
}
