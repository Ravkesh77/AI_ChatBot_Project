package com.chatbot.model;

public class ChatMessage {

    private int id;
    private int userId;
    private String userMessage;
    private String botResponse;

    public ChatMessage() {
    }

    public ChatMessage(int userId, String userMessage, String botResponse) {
        this.userId = userId;
        this.userMessage = userMessage;
        this.botResponse = botResponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getBotResponse() {
        return botResponse;
    }

    public void setBotResponse(String botResponse) {
        this.botResponse = botResponse;
    }
}