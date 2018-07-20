package com.example.demo.controller;

import com.example.demo.utils.TokenUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Controller
@RequestMapping("/get")
public class DataController {
    public static final Logger log = LoggerFactory.getLogger(DataController.class);

    @GetMapping("/sleep-data")
    public String slepp(Model model) {
        try {
            sendGet();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        log.info("slepp data");
        return "redirect:/";
    }

    private void sendGet() throws URISyntaxException, IOException {
        URI uri = new URIBuilder().setScheme("https").setHost("api.fitbit.com").setPath("1.2/user/-/sleep/date/2018-07-20.json").build();
        HttpGet httpGet = new HttpGet(uri);
        httpGet.addHeader("Authorization", "Bearer " + TokenUtils.token);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = httpclient.execute(httpGet);
        log.info("repose statusLine : " + response.getStatusLine());
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        log.info("responseString : " + responseString);

    }
}
