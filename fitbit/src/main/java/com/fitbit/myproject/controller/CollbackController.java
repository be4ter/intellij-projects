package com.fitbit.myproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CollbackController {
    public static final Logger log = LoggerFactory.getLogger(CollbackController.class);

    @GetMapping("/callback")
    public void printCode(HttpServletResponse response, String code) throws IOException {
        log.error("code : " + code);
        response.getWriter().print(code);
    }

}
