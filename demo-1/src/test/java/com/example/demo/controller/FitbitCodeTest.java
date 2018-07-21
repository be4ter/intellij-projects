package com.example.demo.controller;

import com.example.demo.domain.FitbitCode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FitbitCodeTest {
    FitbitCode fitbitCode1;
    FitbitCode fitbitCode2;


    public void setUp() {
        fitbitCode1 = new FitbitCode("test");
        fitbitCode2 = new FitbitCode();
    }

    @Test
    public void create() {
        assertFalse(fitbitCode1.isNull());
        assertTrue(fitbitCode2.isNull());
    }
}
