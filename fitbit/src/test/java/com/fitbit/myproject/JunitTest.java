package com.fitbit.myproject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JunitTest {
    public static final Logger log = LoggerFactory.getLogger(JunitTest.class);

    @Test
    public void init() {
        log.debug("msg");
        log.error("error");
        log.info("info");
        log.trace("trace");
        log.warn("warn");
    }
}
