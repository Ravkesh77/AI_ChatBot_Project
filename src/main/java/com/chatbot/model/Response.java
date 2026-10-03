package com.chatbot.model;

public class Response {

    private int id;
    private int intentId;
    private String responseText;

    public Response() {
    }

    public Response(int id, int intentId, String responseText) {
        this.id = id;
        this.intentId = intentId;
        this.responseText = responseText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIntentId() {
        return intentId;
    }

    public void setIntentId(int intentId) {
        this.intentId = intentId;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }
}