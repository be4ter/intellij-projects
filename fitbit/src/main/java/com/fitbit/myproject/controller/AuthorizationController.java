package com.fitbit.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/generate")
public class AuthorizationController {
    @GetMapping("/code")
    public String code() {
        return "redirect:https://www.fitbit.com/oauth2/authorize?response_type=code&client_id=22CZW9&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fcallback&scope=activity%20heartrate%20location%20nutrition%20profile%20settings%20sleep%20social%20weight&expires_in=604800";
    }
}
