package com.example.demo.controller;

import com.example.demo.Utils.GlobalExecute;
import com.example.demo.domain.GlobalToken;
import com.example.demo.domain.RefreshToken;
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
            model.addAttribute("sleep", sendGet(GlobalToken.getToken().getAccessToken()));
        } catch (URISyntaxException | IOException | NullPointerException e) {
            e.printStackTrace();
            return "redirect:/";
        }
        log.info("slepp data");
        return "/data";
    }

    private String sendGet(String accessToken) throws URISyntaxException, IOException {
        CloseableHttpResponse response = GlobalExecute.getMethod(new HttpGet(createDataURI()), accessToken);
        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }

    private URI createDataURI() throws URISyntaxException {
        return new URIBuilder().setScheme("https").setHost("api.fitbit.com").setPath("1.2/user/-/sleep/date/2018-07-20.json").build();
    }
}
