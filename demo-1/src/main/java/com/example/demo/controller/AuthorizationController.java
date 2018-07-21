package com.example.demo.controller;

import com.example.demo.Utils.GlobalExecute;
import com.example.demo.domain.AuthToken;
import com.example.demo.domain.FitbitCode;
import com.example.demo.domain.GlobalToken;
import org.apache.http.client.methods.CloseableHttpResponse;
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
import java.net.URISyntaxException;

@Controller
@RequestMapping("/generate")
public class AuthorizationController {
    public static final Logger log = LoggerFactory.getLogger(AuthorizationController.class);

    @GetMapping("/code")
    public String code() {
        return String.format("redirect:https://www.fitbit.com/oauth2/authorize?response_type=%s&client_id=%s&redirect_uri=%s&scope=%s", "code", "22CZW9", "http://localhost:8080/callback", "activity heartrate location nutrition profile settings sleep social weight");
    }

    @PostMapping("/token/{code}")
    public String token(@PathVariable String code) throws IOException, URISyntaxException, ParseException {
        log.info("code : " + code);
        sendPost(new FitbitCode(code));
        return "redirect:/";
    }

    private void sendPost(FitbitCode code) throws IOException, URISyntaxException, ParseException {
        if (GlobalToken.isNull()) {
            JSONObject json = createJsonObject(EntityUtils.toString(GlobalExecute.tokenGenerate(code).getEntity(), "UTF-8"));
            GlobalToken.token = AuthToken.create(json);
        } else {
            log.info("이미 토큰이 발급 되었습니다.");
        }
    }

    private JSONObject createJsonObject(String responseString) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(responseString);
    }
}
