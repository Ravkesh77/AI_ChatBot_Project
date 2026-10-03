package com.chatbot.chatbot;

public class NLPProcessor {

    public String detectIntent(String message) {

        message = message.toLowerCase().trim();

        if (message.contains("hello") ||
                message.contains("hi") ||
                message.contains("hey")) {

            return "GREETING";
        }

        if (message.contains("your name") ||
                message.contains("who are you")) {

            return "NAME";
        }

        if (message.contains("how are you")) {

            return "HOW_ARE_YOU";
        }

        if (message.contains("java")) {

            return "JAVA";
        }

        if (message.contains("oop") ||
                message.contains("object oriented")) {

            return "OOP";
        }

        if (message.contains("help")) {

            return "HELP";
        }

        if (message.contains("bye") ||
                message.contains("goodbye")) {

            return "GOODBYE";
        }

        return "UNKNOWN";
    }
}