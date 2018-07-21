package com.example.demo.controller;

import com.example.demo.Utils.GlobalExecute;
import com.example.demo.domain.GlobalToken;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
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
        GlobalToken.revoke();
        return "redirect:/";
    }

    private void sendPost() throws URISyntaxException, IOException {
        log.info("token : " + GlobalToken.getToken().getAccessToken());
        log.info("repose statusLine : " + GlobalExecute.postMethodRevoke(new HttpPost(createURI())).getStatusLine().getStatusCode());

    }

    private URI createURI() throws URISyntaxException {
        return new URIBuilder().setScheme("https").setHost("api.fitbit.com").setPath("/oauth2/revoke").
                setParameter("token", GlobalToken.getToken().getAccessToken()).build();
    }
}
