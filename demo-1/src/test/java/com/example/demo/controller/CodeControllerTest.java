package com.example.demo.controller;


import com.example.demo.domain.FitbitCode;
import com.example.demo.utils.MyRedirectHandler;
import org.apache.http.HttpResponse;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class CodeControllerTest {
    public static final Logger log = LoggerFactory.getLogger(CodeControllerTest.class);
    CodeController codeController;
    HttpResponse response;
    MyRedirectHandler handler;

    @Before
    public void setUp() {
        codeController = new CodeController();
        handler = new MyRedirectHandler();

    }

    @Test
    public void createCodeGenerateUrl() throws IOException {
        response = codeController.createCodeGenerateURI("22CZW9", "http://localhost:8080/callback", "sleep", "604800");
        assertEquals(200, response.getStatusLine().getStatusCode());

    }
}
