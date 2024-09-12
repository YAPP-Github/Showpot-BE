package org.example.util;

public final class ParseToken {

    public static String getAccessToken(String accessToken) {
        return accessToken.replace("Bearer ", "");
    }
}
