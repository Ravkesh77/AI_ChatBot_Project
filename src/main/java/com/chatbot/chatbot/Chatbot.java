package com.chatbot.chatbot;

public class Chatbot {

    private IntentDetector intentDetector;
    private ResponseManager responseManager;

    public Chatbot() {

        intentDetector = new IntentDetector();
        responseManager = new ResponseManager();
    }

    public String getResponse(String message) {

        String intent =
                intentDetector.detectIntent(message);

        return responseManager.getResponse(intent);
    }
}