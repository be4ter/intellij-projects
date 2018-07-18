package com.fitbit.myproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    public static final Logger log =  LoggerFactory.getLogger(IndexController.class);
    @GetMapping("")
    public String index() {
        return "/index";
    }

    @GetMapping("/hello")
    public void test() {
        log.error("잘못된 요창");
    }
}
