package com.fitbit.myproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    public static final Logger log = LoggerFactory.getLogger(IndexController.class);
    private String code;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("code", code);
        return "/index";
    }

    @GetMapping("/callback")
    public String printCode(String code) {
        this.code = code;
        log.info("code :" + code);
        return "redirect:/";
    }
}
