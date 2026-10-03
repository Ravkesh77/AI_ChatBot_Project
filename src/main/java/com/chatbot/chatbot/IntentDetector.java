package com.chatbot.chatbot;

public class IntentDetector {

    private NLPProcessor nlpProcessor;

    public IntentDetector() {
        nlpProcessor = new NLPProcessor();
    }

    public String detectIntent(String message) {

        if (message == null || message.trim().isEmpty()) {
            return "UNKNOWN";
        }

        return nlpProcessor.detectIntent(
                message.toLowerCase().trim()
        );
    }
}