package com.chatbot.utils;

public class ValidationUtil {

    public static boolean isEmpty(String value) {

        return value == null ||
                value.trim().isEmpty();
    }

    public static boolean isValidUsername(
            String username) {

        return username != null &&
                username.matches(
                        "^[a-zA-Z0-9_]{3,20}$"
                );
    }

    public static boolean isValidPassword(
            String password) {

        return password != null &&
                password.length() >= 4;
    }
}