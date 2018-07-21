package com.example.demo.domain;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URISyntaxException;

public class GlobalToken {
    public static AuthToken authToken;

    public static boolean isNull() {
        return authToken == null;
    }

    public static AuthToken getAuthToken() {
        return authToken;
    }

    public static RefreshToken getRefreshToken() {
        try {
            return RefreshToken.generate(authToken.getRefreshToken());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
