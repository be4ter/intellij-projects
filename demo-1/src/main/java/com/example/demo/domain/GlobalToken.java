package com.example.demo.domain;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URISyntaxException;

public class GlobalToken {
    public static AuthToken token;

    public static boolean isNull() {
        return token == null;
    }

    public static AuthToken getToken() {
        return token;
    }

    public static RefreshToken getRefreshToken() {
        try {
            return RefreshToken.generate(token.getRefreshToken());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void revoke() {
        token = null;
    }
}
